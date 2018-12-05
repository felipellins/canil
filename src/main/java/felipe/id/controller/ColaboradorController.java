/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.controller;

import felipe.id.model.Colaborador;
import felipe.id.model.ColaboradorModel;
import felipe.id.model.Endereço;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Felipe
 */
@SessionScoped
@ManagedBean 
public class ColaboradorController {
	  private ColaboradorModel colaboradorModel;
	   private Colaborador colaborador;
	   private Endereço endereço;
	   private Colaborador selectedColaborador;
	  
	   public ColaboradorController(){
	       
	       this.colaboradorModel = new ColaboradorModel();
	       this.colaborador = new Colaborador();
	       this.endereço= new Endereço();
	   } 
	   
	    public void registrarColaborador() {
	        
	       this.colaborador.setEndereço(this.endereço); 
	       this.colaboradorModel.cadastrarColaborador(this.colaborador);
	       this.colaborador = new Colaborador();
	       this.endereço= new Endereço();
	      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Colaborador cadastrado com sucesso!"));  
	    }   
	    public void removerColaborador(Integer idCol) {
	      this.colaboradorModel.removerColaborador(idCol);
	    }
	    
	    public void alterarColaborador() {
	      this.colaboradorModel.alterarColaborador(this.selectedColaborador);
	    }
	    
	    public Colaborador recuperarID(String  cpf) {
	        return colaboradorModel.recuperar(cpf);
	    }
	    
	    public List<Colaborador> recuperarTodos() {
	        return colaboradorModel.RecuperarTodos();
	    }

	    public Endereço getEndereço() {
	        return endereço;
	    }

	    public void setEndereço(Endereço endereço) {
	        this.endereço = endereço;
	    }
	    public Colaborador getColaborador() {
	        return colaborador;
	    }

	    public void setColaborador(Colaborador colaborador) {
	        this.colaborador = colaborador;
	    }

	   
	    
	}


