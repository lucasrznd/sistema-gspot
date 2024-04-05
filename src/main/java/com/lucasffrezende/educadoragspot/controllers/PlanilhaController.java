package com.lucasffrezende.educadoragspot.controllers;

import com.lucasffrezende.educadoragspot.utils.ConversorDataUtil;
import org.springframework.stereotype.Component;

@Component
public class PlanilhaController {

    public String dataNomeArquivo() {
        return ConversorDataUtil.dataNomeArquivo();
    }

}
