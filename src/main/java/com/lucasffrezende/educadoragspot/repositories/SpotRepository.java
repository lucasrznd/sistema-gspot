package com.lucasffrezende.educadoragspot.repositories;

import com.lucasffrezende.educadoragspot.models.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Long> {

    List<Spot> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);

    @Query(value = "SELECT s FROM Spot s "
            + "WHERE s.data BETWEEN :dataInicial AND :dataFinal "
            + "AND (COALESCE(:nomeEmpresa, '') = '' OR s.empresa.nome LIKE :nomeEmpresa) "
            + "AND (COALESCE(:nomeLocutor, '') = '' OR s.locutor.nome LIKE :nomeLocutor) "
            + "ORDER BY s.data ASC")
    List<Spot> buscarPorIntervaloDataEmpresaNomeLocutorNome(LocalDate dataInicial, LocalDate dataFinal, String nomeEmpresa, String nomeLocutor);


}
