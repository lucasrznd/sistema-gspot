package com.lucasffrezende.educadoragspot.repositories;

import com.lucasffrezende.educadoragspot.models.Locutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocutorRepository extends JpaRepository<Locutor, Long> {

    @Query("SELECT l FROM Locutor l WHERE l.nome LIKE %?1%")
    List<Locutor> buscaPorNome(String nome);

}
