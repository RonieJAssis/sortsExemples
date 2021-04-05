/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.dao.Ordem;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ronie
 */
@FacesConverter(value = "converterOrdem")
@RequestScoped
public class ConverterOrdem implements Serializable,Converter{
    
    private List<Ordem> listaOrderm;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        for(Ordem o:listaOrderm){
            if(o.getAtributo().equals(string)){
                return o;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if(t==null){
            return null;
        }
        return t.toString();
    }

    /**
     * @return the listaOrderm
     */
    public List<Ordem> getListaOrderm() {
        return listaOrderm;
    }

    /**
     * @param listaOrderm the listaOrderm to set
     */
    public void setListaOrderm(List<Ordem> listaOrderm) {
        this.listaOrderm = listaOrderm;
    }
    
}
