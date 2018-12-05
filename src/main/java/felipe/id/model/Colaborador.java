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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "colaborador")
public class Colaborador implements Serializable {

	@Id
        @Column(name="id_col",nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int idCol;
	@Column(length = 20,nullable = false)
        private String cpf;
	@Column(name="nome_col",length = 60)
	private String nomeCol;
	@Column(length = 60,nullable = false)
	private String login;
	@Column(length = 20,nullable = false)
	private String senha;

	@ManyToMany
	@JoinTable(name = "colaborador_no_canil", joinColumns = {
			@JoinColumn(name = "colaborador_id_col", referencedColumnName = "id_col") }, inverseJoinColumns = {
					@JoinColumn(name = "canil_id_canil", referencedColumnName = "id_canil") })

	private List<Canil> listaCanis;

	@Embedded
	Endereço endereço;

	public Colaborador() {

	}

    public Colaborador( String cpf, String nomeCol, String login, String senha, List<Canil> listaCanis, Endereço endereço) {
       
        this.cpf = cpf;
        this.nomeCol = nomeCol;
        this.login = login;
        this.senha = senha;
        this.listaCanis = listaCanis;
        this.endereço = endereço;
    }
  
    public int getIdCol() {
        return idCol;
    }

    public void setIdCol(int idCol) {
        this.idCol = idCol;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCol() {
        return nomeCol;
    }

    public void setNomeCol(String nomeCol) {
        this.nomeCol = nomeCol;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Canil> getListaCanis() {
        return listaCanis;
    }

    public void setListaCanis(List<Canil> listaCanis) {
        this.listaCanis = listaCanis;
    }

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
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
        final Colaborador other = (Colaborador) obj;
        if (this.idCol != other.idCol) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nomeCol, other.nomeCol)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.listaCanis, other.listaCanis)) {
            return false;
        }
        if (!Objects.equals(this.endereço, other.endereço)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idCol;
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.nomeCol);
        hash = 97 * hash + Objects.hashCode(this.login);
        hash = 97 * hash + Objects.hashCode(this.senha);
        hash = 97 * hash + Objects.hashCode(this.listaCanis);
        hash = 97 * hash + Objects.hashCode(this.endereço);
        return hash;
    }

    public String toString() {
        return "Colaborador{" + "idCol=" + idCol + ", cpf=" + cpf + ", nomeCol=" + nomeCol + ", login=" + login + ", senha=" + senha + ", listaCanis=" + listaCanis + ", endere\u00e7o=" + endereço + '}';
    }

}