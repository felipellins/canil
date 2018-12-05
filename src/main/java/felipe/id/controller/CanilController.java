/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.controller;

import felipe.id.model.Canil;
import felipe.id.model.CanilModel;
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
public class CanilController {

	  private CanilModel canilModel;
	   private Canil canil;
	   private Endereço endereço;
	   private Canil selectedCanil;
	  
	   public CanilController(){
	       
	       this.canilModel = new CanilModel();
	       this.canil = new Canil();
	       this.endereço= new Endereço();
	   } 
	   
	    public void registrarCanil() {
	        
	       this.canil.setEndereço(this.endereço); 
	       this.canilModel.cadastrarCanil(this.canil);
	      this.canil = new Canil();
	      this.endereço= new Endereço();
	      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Canil cadastrado com sucesso!"));  
	    }   
	    public void removerCanil(int idCanil) {
	      this.canilModel.removerCanil(idCanil);
	    }
	    
	    public void alterarCliente() {
	      this.canilModel.alterarCanil(this.selectedCanil);
	    }
	    
	    public Canil recuperarID(String  codCanil) {
	        return canilModel.recuperar(codCanil);
	    }
	    
	    public List<Canil> recuperarTodos() {
	        return canilModel.RecuperarTodos();
	    }

	    public Endereço getEndereço() {
	        return endereço;
	    }

	    public void setEndereço(Endereço endereço) {
	        this.endereço = endereço;
	    }
	    public Canil getCanil() {
	        return canil;
	    }

	    public void setCanil(Canil canil) {
	        this.canil = canil;
	    }

	   
	    
	}
	
