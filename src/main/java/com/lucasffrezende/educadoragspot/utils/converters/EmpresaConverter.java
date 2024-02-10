package com.lucasffrezende.educadoragspot.utils.converters;

import com.lucasffrezende.educadoragspot.models.Empresa;
import com.lucasffrezende.educadoragspot.services.EmpresaService;
import io.micrometer.common.util.StringUtils;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FacesConverter(forClass = Empresa.class)
public class EmpresaConverter implements Converter<Empresa> {

    @Autowired
    private EmpresaService empresaService;

    @Override
    public Empresa getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Empresa retorno = null;

        if (StringUtils.isNotBlank(value)) {
            retorno = this.empresaService.buscaPorCodigo(Long.parseLong(value));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Empresa value) {
        if (value != null) {
            Long codigo = ((Empresa) value).getCodigo();
            String retorno = (codigo == null ? null : codigo.toString());

            return retorno;
        }

        return "";
    }

}