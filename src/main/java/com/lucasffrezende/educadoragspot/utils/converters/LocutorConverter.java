package com.lucasffrezende.educadoragspot.utils.converters;

import com.lucasffrezende.educadoragspot.models.Locutor;
import com.lucasffrezende.educadoragspot.services.LocutorService;
import io.micrometer.common.util.StringUtils;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FacesConverter(forClass = Locutor.class)
public class LocutorConverter implements Converter<Locutor> {

    @Autowired
    private LocutorService locutorService;

    @Override
    public Locutor getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Locutor retorno = null;

        if (StringUtils.isNotBlank(value)) {
            retorno = this.locutorService.buscaPorCodigo(Long.parseLong(value));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Locutor value) {
        if (value != null) {
            Long codigo = ((Locutor) value).getCodigo();
            String retorno = (codigo == null ? null : codigo.toString());

            return retorno;
        }

        return "";
    }

}