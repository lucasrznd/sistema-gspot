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
import java.util.Arrays;
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

    public Double calcularValorTotal(List<Spot> spotList) {
        double valorTotal = 0.0;

        for (Spot spot : spotList) {
            valorTotal += spot.getPreco();
        }

        return valorTotal;
    }

    public List<Spot> buscarSpot(List<LocalDate> datas, Spot spotEntity) {
        try {
            if (datas.isEmpty()) {
                datas = datasPadroes();
            }

            spotEntity = spotPadrao(spotEntity);

            List<Spot> spotList = repository.
                    buscarPorIntervaloDataEmpresaNomeLocutorNome(datas.get(0), datas.get(1), spotEntity.getEmpresa().getNome(), spotEntity.getLocutor().getNome());

            if (spotList.isEmpty()) {
                GrowlView.showWarn(MensagemEnum.MSG_ERRO.getMsg(), MensagemEnum.MSG_NENHUM_REGISTRO.getMsg());
            }

            return spotList;
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_AVISO.getMsg(), "Erro ao realizar busca.");
        }
        return null;
    }

    public List<LocalDate> datasPadroes() {
        LocalDate dataInicio = LocalDate.of(LocalDate.now().getYear(), 01, 01);
        LocalDate dataFim = LocalDate.of(LocalDate.now().getYear(), 12, 30);

        List<LocalDate> datas = Arrays.asList(dataInicio, dataFim);
        return datas;
    }

    public Spot spotPadrao(Spot spotEntity) {
        if (spotEntity.getEmpresa() == null) {
            spotEntity.setEmpresa(new Empresa());

            if (spotEntity.getEmpresa().getNome() == null) {
                spotEntity.getEmpresa().setNome("");
            }
        }

        if (spotEntity.getLocutor() == null) {
            spotEntity.setLocutor(new Locutor());

            if (spotEntity.getLocutor().getNome() == null) {
                spotEntity.getLocutor().setNome("");
            }
        }

        return spotEntity;
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
