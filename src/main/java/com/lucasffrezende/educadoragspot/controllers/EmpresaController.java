package com.lucasffrezende.educadoragspot.controllers;

import com.lucasffrezende.educadoragspot.models.Empresa;
import com.lucasffrezende.educadoragspot.services.EmpresaService;
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
public class EmpresaController implements Serializable {

    @Autowired
    private EmpresaService service;
    private Empresa empresa;
    private List<Empresa> empresaList;

    @PostConstruct
    public void init() {
        empresa = new Empresa();

        empresaList = service.listar();
    }

    public void salvar() {
        service.salvar(empresa);
        empresaList = service.listar();
    }

    public void excluir() {
        service.excluir(empresa.getCodigo());
        empresaList = service.listar();
    }

}
