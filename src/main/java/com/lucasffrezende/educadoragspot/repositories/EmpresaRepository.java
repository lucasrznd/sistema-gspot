package com.lucasffrezende.educadoragspot.repositories;

import com.lucasffrezende.educadoragspot.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("SELECT e FROM Empresa e WHERE e.nome LIKE %?1%")
    List<Empresa> buscaPorNome(String nome);

}
