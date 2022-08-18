package com.diegocarvalhoapi.parkingapi.repositories;

import com.diegocarvalhoapi.parkingapi.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    boolean existsByplacaCarro(String placaCarro);
    boolean existsBynumeroVaga(String numeroVaga);
    boolean existsByApartamentoEBloco(String apartamento, String bloco);
}