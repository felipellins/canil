/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 *
 * @author Felipe
 */

 
 @Embeddable
 public class Endereço implements Serializable {
    
    @Column(length=30)
    private String cidade;
    @Column(length=40)
    private String rua;
    @Column(length=10)
    private int numero;
    @Column(length=40)
    private String estado;
    
    public Endereço(){
        
    }

    public Endereço(String cidade, String rua, int numero, String estado) {
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.estado = estado;
    }
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Endereço other = (Endereço) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endere\u00e7o{" + "cidade=" + cidade + ", rua=" + rua + ", numero=" + numero + ", estado=" + estado + '}';
    }
    
}
