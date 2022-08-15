package com.diegocarvalhoapi.parkingapi.controllers;


import com.diegocarvalhoapi.parkingapi.dtos.ParkingSpotDto;
import com.diegocarvalhoapi.parkingapi.models.ParkingSpotModel;
import com.diegocarvalhoapi.parkingapi.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        if(parkingSpotService.existsByPlacaCarro(parkingSpotDto.getPlacaCarro())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Placa do carro ja está em uso");
        }
        if(parkingSpotService.existsByNumeroVaga(parkingSpotDto.getNumeroVaga())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A vaga ja está em uso");
        }
        if(parkingSpotService.existsByApartamentoEBloco(parkingSpotDto.getApartamento(), parkingSpotDto.getBloco())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A vaga ja está associada a este apartamento/bloco");
        }


        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

}
