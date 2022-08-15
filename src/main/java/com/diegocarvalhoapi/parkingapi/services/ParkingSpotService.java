package com.diegocarvalhoapi.parkingapi.services;

import com.diegocarvalhoapi.parkingapi.models.ParkingSpotModel;
import com.diegocarvalhoapi.parkingapi.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByPlacaCarro(String placaCarro) {
        return parkingSpotRepository.existsByPlacaCarro(placaCarro);
    }

    public boolean existsByNumeroVaga(String numeroVaga) {
        return parkingSpotRepository.existsByNumeroVaga(numeroVaga);
    }


    public boolean existsByApartamentoEBloco(String apartamento, String bloco) {
        return parkingSpotRepository.existsByApartamentoEBloco(apartamento, bloco);
    }


}
