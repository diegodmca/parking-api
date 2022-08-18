package com.diegocarvalhoapi.parkingapi.services;

import com.diegocarvalhoapi.parkingapi.models.ParkingSpotModel;
import com.diegocarvalhoapi.parkingapi.repositories.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

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
        return parkingSpotRepository.existsByplacaCarro(placaCarro);
    }

    public boolean existsByNumeroVaga(String numeroVaga) {
        return parkingSpotRepository.existsBynumeroVaga(numeroVaga);
    }


    public boolean existsByApartamentoEBloco(String apartamento, String bloco) {
        return parkingSpotRepository.existsByApartamentoEBloco(apartamento, bloco);
    }
    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }


}
