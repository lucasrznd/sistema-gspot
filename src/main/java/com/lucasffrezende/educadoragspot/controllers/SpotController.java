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
import java.time.LocalDate;
import java.util.ArrayList;
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
    private List<LocalDate> range;

    @PostConstruct
    public void init() {
        spotEntity = new Spot();
        spotEntity.setLocutor(new Locutor());
        spotEntity.setEmpresa(new Empresa());

        spotList = service.listar();
        duracaoString = null;
        range = new ArrayList<>();
    }

    public void converterDuracao() {
        spotEntity.setDuracao(service.converterStringParaDouble(duracaoString));
        calcularPreco();
    }

    public void calcularPreco() {
        spotEntity.setPreco(service.calcularPreco(spotEntity));
    }

    public Double calcularValorTotal() {
        return service.calcularValorTotal(spotList);
    }

    public List<Empresa> buscarEmpresaPorNome(String nome) {
        return service.buscarEmpresaPorNome(nome);
    }

    public List<Locutor> buscarLocutorPorNome(String nome) {
        return service.buscarLocutorPorNome(nome);
    }

    public void buscar() {
        spotList = service.buscarSpot(range, spotEntity);
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