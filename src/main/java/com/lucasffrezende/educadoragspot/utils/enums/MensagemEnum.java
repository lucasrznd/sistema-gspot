package com.lucasffrezende.educadoragspot.utils.enums;

import lombok.Getter;

@Getter
public enum MensagemEnum {

    MSG_SUCESSO("Sucesso."),
    MSG_AVISO("Aviso."),
    MSG_ERRO("Erro."),
    MSG_SALVO_SUCESSO("Registro salvo com sucesso."),
    MSG_ERRO_SALVAR("Erro ao salvar registro."),
    MSG_ERRO_EXCLUIR("Erro ao remover registro."),
    MSG_IMPORT_SUCESSO("Importado com sucesso."),
    MSG_EXCLUIDO_SUCESSO("Registro removido com sucesso."),
    MSG_OPERACAO_CONCLUIDA_SUCESSO("Operação concluída com sucesso."),
    MSG_NENHUM_REGISTRO("Nenhum registro encontrado."),
    MSG_REGISTRO_EXISTENTE("Registro já existente.");

    private String msg;

    private MensagemEnum(String msg) {
        this.msg = msg;
    }

}
