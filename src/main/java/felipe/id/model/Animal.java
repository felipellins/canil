/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "animal")
public class Animal implements Serializable  {

	@Id
        @Column(name="id_animal",nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO)
	private int idAnimal;
	@Column(length = 20,nullable = false, unique = true)
        private String codAnimal;
	@Column(name="nome_ani",length = 30, nullable = false)
	private String nomeAni;
	@Column(length = 10,nullable = false)
	private int idade;
	@Column(length = 10)
	private String porte;
	@Column(length = 20)
	private String raça;
	@Column(length = 10, nullable = false)
	private String tipo;
	@Column(length = 10, nullable = false)
	private String data_entrada;
	@Column(length = 10)
	private String data_adotado;

	// muitos animais para um cliente
	@JoinColumn(name = "cliente_id_cli", referencedColumnName = "id_cli")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Cliente cliente;

	// muitos animais para um canil
	@JoinColumn(name = "canil_id_canil", referencedColumnName = "id_canil")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Canil canil;

	public Animal() {

	}

        
    public Animal( String codAnimal, String nomeAni, int idade, String porte,
            String raça, String tipo, String data_entrada, String data_adotado, Cliente cliente, Canil canil) {
       
        this.codAnimal = codAnimal;
        this.nomeAni = nomeAni;
        this.idade = idade;
        this.porte = porte;
        this.raça = raça;
        this.tipo = tipo;
        this.data_entrada = data_entrada;
        this.data_adotado = data_adotado;
        this.cliente = cliente;
        this.canil = canil;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(String codAnimal) {
        this.codAnimal = codAnimal;
    }

    public String getNomeAni() {
        return nomeAni;
    }

    public void setNomeAni(String nomeAni) {
        this.nomeAni = nomeAni;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getData_adotado() {
        return data_adotado;
    }

    public void setData_adotado(String data_adotado) {
        this.data_adotado = data_adotado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Canil getCanil() {
        return canil;
    }

    public void setCanil(Canil canil) {
        this.canil = canil;
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
        final Animal other = (Animal) obj;
        if (this.idAnimal != other.idAnimal) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.codAnimal, other.codAnimal)) {
            return false;
        }
        if (!Objects.equals(this.nomeAni, other.nomeAni)) {
            return false;
        }
        if (!Objects.equals(this.porte, other.porte)) {
            return false;
        }
        if (!Objects.equals(this.raça, other.raça)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.data_entrada, other.data_entrada)) {
            return false;
        }
        if (!Objects.equals(this.data_adotado, other.data_adotado)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.canil, other.canil)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + idAnimal + ", codAnimal=" + codAnimal + ", nomeAni=" + nomeAni + ", idade=" + idade + ", porte=" + porte + ", ra\u00e7a=" + raça + ", tipo=" + tipo + ", data_entrada=" + data_entrada + ", data_adotado=" + data_adotado + ", cliente=" + cliente + ", canil=" + canil + '}';
    }

	
}
	