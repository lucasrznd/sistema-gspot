package com.lucasffrezende.educadoragspot.services;

import com.lucasffrezende.educadoragspot.models.Locutor;
import com.lucasffrezende.educadoragspot.repositories.LocutorRepository;
import com.lucasffrezende.educadoragspot.utils.GrowlView;
import com.lucasffrezende.educadoragspot.utils.enums.MensagemEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocutorService {

    @Autowired
    private LocutorRepository repository;

    public List<Locutor> listar() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Erro ao carregar locutores.");
        }
        return null;
    }

    public List<Locutor> buscaPorNome(String nome) {
        try {
            return repository.buscaPorNome(nome);
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Erro ao encontrar locutor.");
        }
        return null;
    }

    public Locutor buscaPorCodigo(Long codigo) {
        try {
            return repository.findById(codigo).get();
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Erro ao encontrar locutor.");
        }
        return null;
    }

    public void salvar(Locutor locutor) {
        try {
            Locutor locutorExistente = repository.findByNome(locutor.getNome());

            if (locutorExistente != null) {
                GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Locutor já cadastrado.");
                return;
            }

            repository.save(locutor);

            GrowlView.showInfo(MensagemEnum.MSG_SUCESSO.getMsg(), MensagemEnum.MSG_SALVO_SUCESSO.getMsg());
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), MensagemEnum.MSG_ERRO_EXCLUIR.getMsg());
        }
    }

    public void excluir(Long codigo) {
        try {
            repository.deleteById(codigo);

            GrowlView.showInfo(MensagemEnum.MSG_SUCESSO.getMsg(), MensagemEnum.MSG_EXCLUIDO_SUCESSO.getMsg());
        } catch (DataIntegrityViolationException e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Locutor selecionado possui spots ativos.");
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), MensagemEnum.MSG_ERRO_EXCLUIR.getMsg());
        }
    }

}
