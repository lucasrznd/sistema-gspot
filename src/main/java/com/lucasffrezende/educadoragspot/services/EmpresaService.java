package com.lucasffrezende.educadoragspot.services;

import com.lucasffrezende.educadoragspot.models.Empresa;
import com.lucasffrezende.educadoragspot.repositories.EmpresaRepository;
import com.lucasffrezende.educadoragspot.utils.GrowlView;
import com.lucasffrezende.educadoragspot.utils.enums.MensagemEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> listar() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Erro ao carregar empresas.");
        }
        return null;
    }

    public List<Empresa> buscaPorNome(String nome) {
        try {
            return repository.buscaPorNome(nome);
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Erro ao encontrar empresa.");
        }
        return null;
    }

    public Empresa buscaPorCodigo(Long codigo) {
        try {
            return repository.findById(codigo).get();
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Erro ao encontrar empresa.");
        }
        return null;
    }

    public void salvar(Empresa empresa) {
        try {
            Empresa empresaExistente = repository.findByNome(empresa.getNome());

            if (empresaExistente != null) {
                GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Empresa já cadastrada.");
                return;
            }

            repository.save(empresa);

            GrowlView.showInfo(MensagemEnum.MSG_SUCESSO.getMsg(), MensagemEnum.MSG_SALVO_SUCESSO.getMsg());
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), MensagemEnum.MSG_ERRO_SALVAR.getMsg());
        }
    }

    public void excluir(Long codigo) {
        try {
            repository.deleteById(codigo);

            GrowlView.showInfo(MensagemEnum.MSG_SUCESSO.getMsg(), MensagemEnum.MSG_EXCLUIDO_SUCESSO.getMsg());
        } catch (DataIntegrityViolationException e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), "Empresa selecionada possui spots ativos.");
        } catch (Exception e) {
            GrowlView.showError(MensagemEnum.MSG_ERRO.getMsg(), MensagemEnum.MSG_ERRO_EXCLUIR.getMsg());
        }
    }

}
