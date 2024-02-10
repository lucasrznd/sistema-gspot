package com.lucasffrezende.educadoragspot.services;

import com.lucasffrezende.educadoragspot.models.Empresa;
import com.lucasffrezende.educadoragspot.models.Locutor;
import com.lucasffrezende.educadoragspot.models.Spot;
import com.lucasffrezende.educadoragspot.repositories.SpotRepository;
import com.lucasffrezende.educadoragspot.utils.GrowlView;
import com.lucasffrezende.educadoragspot.utils.enums.MensagemEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class SpotService {

    @Autowired
    private SpotRepository repository;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private LocutorService locutorService;

    public List<Spot> listar() {
        return repository.findAll();
    }

    public Double converterStringParaDouble(String duracaoString) {
        String duracaoSemFormato = duracaoString.replaceAll(":", ".");
        double duracaoDouble = Double.parseDouble(duracaoSemFormato);
        return duracaoDouble;
    }

    public Double calcularPreco(Spot spotEntity) {
        double precoSpot = 0.0;

        if (spotEntity.getDuracao() != null) {
            if (spotEntity.isContratoAtivo() && spotEntity.getDuracao() <= 0.35) {
                precoSpot = 0.0;
            } else if (spotEntity.getDuracao() <= 1.0) {
                precoSpot = 20.00;
            } else if (spotEntity.getDuracao() > 1.0 && spotEntity.getDuracao() <= 2.0) {
                precoSpot = 25.00;
            } else if (spotEntity.getDuracao() > 2.0) {
                precoSpot = 35.00;
            }
        }

        return precoSpot;
    }

    public List<Empresa> buscarEmpresaPorNome(String nome) {
        return empresaService.buscaPorNome(nome);
    }

    public List<Locutor> buscarLocutorPorNome(String nome) {
        return locutorService.buscaPorNome(nome);
    }

    public void salvar(Spot spotEntity) {
        try {
            spotEntity.setData(LocalDate.now());
            repository.save(spotEntity);

            GrowlView.showInfo(MensagemEnum.MSG_SUCESSO.getMsg(), MensagemEnum.MSG_SALVO_SUCESSO.getMsg());
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), MensagemEnum.MSG_ERRO_SALVAR.getMsg());
        }
    }

    public void excluir(Long codigo) {
        try {
            repository.deleteById(codigo);

            GrowlView.showInfo(MensagemEnum.MSG_SUCESSO.getMsg(), MensagemEnum.MSG_EXCLUIDO_SUCESSO.getMsg());
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), MensagemEnum.MSG_ERRO_EXCLUIR.getMsg());
        }
    }

}
