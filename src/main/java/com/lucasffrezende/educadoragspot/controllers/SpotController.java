package com.lucasffrezende.educadoragspot.controllers;

import com.lucasffrezende.educadoragspot.models.Empresa;
import com.lucasffrezende.educadoragspot.models.Locutor;
import com.lucasffrezende.educadoragspot.models.Spot;
import com.lucasffrezende.educadoragspot.services.SpotService;
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
public class SpotController implements Serializable {

    @Autowired
    private SpotService service;
    private Spot spotEntity;
    private List<Spot> spotList;

    private String duracaoString;

    @PostConstruct
    public void init() {
        spotEntity = new Spot();
        spotEntity.setLocutor(new Locutor());
        spotEntity.setEmpresa(new Empresa());

        spotList = service.listar();
        duracaoString = null;
    }

    public void converterDuracao() {
        spotEntity.setDuracao(service.converterStringParaDouble(duracaoString));
        calcularPreco();
    }

    public void calcularPreco() {
        spotEntity.setValorTotal(service.calcularPreco(spotEntity));
    }

    public List<Empresa> buscarEmpresaPorNome(String nome) {
        return service.buscarEmpresaPorNome(nome);
    }

    public List<Locutor> buscarLocutorPorNome(String nome) {
        return service.buscarLocutorPorNome(nome);
    }

    public void salvar() {
        service.salvar(spotEntity);
        spotList = service.listar();
    }

    public void excluir() {
        service.excluir(spotEntity.getCodigo());
        spotList = service.listar();
    }

}
