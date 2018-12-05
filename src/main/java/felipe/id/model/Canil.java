/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "canil")
public class Canil implements Serializable {

	@Id
        @Column(name="id_canil",nullable = false)
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idCanil;
	@Column(length = 20,nullable = false)
        private String codCanil;
        @Column(length=60,nullable = false)
	private String nome;

	@Embedded
	private Endereço endereço;

	// muitos canis para muitos colaboradores
	@ManyToMany(mappedBy = "listaCanis")
	private List<Colaborador> listaColaboradores;

	
	
	
	public Canil() {

	}

    public Canil( String codCanil, String nome, Endereço endereço, List<Colaborador> listaColaboradores) {
        
        this.codCanil = codCanil;
        this.nome = nome;
        this.endereço = endereço;
        this.listaColaboradores = listaColaboradores;
    }

    public int getIdcanil() {
        return idCanil;
    }

    public void setIdcanil(int idcanil) {
        this.idCanil = idcanil;
    }

    public String getCodCanil() {
        return codCanil;
    }

    public void setCodCanil(String codCanil) {
        this.codCanil = codCanil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }

    public List<Colaborador> getListaColaboradores() {
        return listaColaboradores;
    }

    public void setListaColaboradores(List<Colaborador> listaColaboradores) {
        this.listaColaboradores = listaColaboradores;
    }


    
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
        final Canil other = (Canil) obj;
        if (this.idCanil != other.idCanil) {
            return false;
        }
        if (!Objects.equals(this.codCanil, other.codCanil)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereço, other.endereço)) {
            return false;
        }
        if (!Objects.equals(this.listaColaboradores, other.listaColaboradores)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idCanil;
        hash = 29 * hash + Objects.hashCode(this.codCanil);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.endereço);
        hash = 29 * hash + Objects.hashCode(this.listaColaboradores);
        return hash;
    }

    
    public String toString() {
        return "Canil{" + "idCanil=" + idCanil + ", codCanil=" + codCanil + ", nome=" + nome + ", endere\u00e7o=" + endereço + ", listaColaboradores=" + listaColaboradores + '}';
    }

}