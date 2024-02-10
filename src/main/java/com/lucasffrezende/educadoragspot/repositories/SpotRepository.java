package com.lucasffrezende.educadoragspot.repositories;

import com.lucasffrezende.educadoragspot.models.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Long> {

    List<Spot> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);
    
}
