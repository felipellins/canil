/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



import javax.persistence.Table;

/**
 *
 * @author Felipe
 */

  @Entity
  @Table(name="cliente")
  @NamedQueries({ @NamedQuery(
                             name="cliente.consultarCliente",
                             query="SELECT c "
                                  + "FROM cliente c"
                                  + "WHERE c.clicpf =:cliCpf")
  
  })
public class Cliente implements Serializable {

  @Id
  @Column(name="id_cli",nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int idCli;
  @Column(length=20,nullable = false)
  private String cliCpf;
  @Column(length=60,nullable = false)
  private String nome;
  @Column(length=60,nullable = false)
  private String login;
  @Column(length=20,nullable = false)
  private String senha;
 
  @Embedded
  private Endereço endereço;     
 
  public Cliente(){
      
  }

    public Cliente(String cliCpf, String nome, String login, String senha, Endereço endereço) {
        this.cliCpf = cliCpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.endereço = endereço;
    }

   

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
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
        final Cliente other = (Cliente) obj;
        if (this.idCli != other.idCli) {
            return false;
        }
        if (!Objects.equals(this.cliCpf, other.cliCpf)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.endereço, other.endereço)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCli=" + idCli + ", cliCpf=" + cliCpf + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", endere\u00e7o=" + endereço + '}';
    }

  }