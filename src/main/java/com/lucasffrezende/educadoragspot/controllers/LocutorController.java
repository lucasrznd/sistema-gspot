package com.lucasffrezende.educadoragspot.controllers;

import com.lucasffrezende.educadoragspot.models.Locutor;
import com.lucasffrezende.educadoragspot.services.LocutorService;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.omnifaces.cdi.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Data
public class LocutorController implements Serializable {

    @Autowired
    private LocutorService service;
    private Locutor locutor;
    private List<Locutor> locutorList;

    @PostConstruct
    public void init() {
        locutor = new Locutor();

        locutorList = service.listar();
    }

    public void salvar() {
        service.salvar(locutor);
        locutorList = service.listar();
    }

    public void excluir() {
        service.excluir(locutor.getCodigo());
        locutorList = service.listar();
    }

}
