/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import felipe.id.model.Canil;
import felipe.id.model.CanilModel;
import java.util.Objects;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
// modifiquei aqui ele passava o id para string , mas agora ja esta string 
@FacesConverter("CanilConverter")
public class CanilConverter implements Converter {

    private CanilModel canilModel = new CanilModel();
    private String codCanil;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        Canil canil;
        canil = null;

        try {
           
            canil = this.canilModel.recuperar(codCanil);

        } catch (Exception e) {
            System.out.println(e.getClass() + "  " + e.getMessage());

        }
        return canil;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Canil canil = (Canil) o;
        return canil.getIdcanil() + "";

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.canilModel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CanilConverter other = (CanilConverter) obj;
        if (!Objects.equals(this.canilModel, other.canilModel)) {
            return false;
        }
        return true;
    }
    
}
