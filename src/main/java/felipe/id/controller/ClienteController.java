/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.controller;



import felipe.id.model.Cliente;
import felipe.id.model.ClienteModel;
import felipe.id.model.Endereço;
import java.util.List;
import javax.annotation.PostConstruct;
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


public class ClienteController {

   private ClienteModel clientModel=null;
   private Cliente cliente;
   private Endereço endereço;
   private Cliente selectedCliente;
   private List<Cliente>Clientes;
   
   public ClienteController(){
       
       this.clientModel = new ClienteModel();
       this.cliente = new Cliente();
       this.endereço= new Endereço();
   } 

    public ClienteController(ClienteModel clientModel, Cliente cliente, Endereço endereço, Cliente selectedCliente, List<Cliente> clientes) {
        this.clientModel = clientModel;
        this.cliente = cliente;
        this.endereço = endereço;
        this.selectedCliente = selectedCliente;
       
    }

    public ClienteModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClienteModel clientModel) {
        this.clientModel = clientModel;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }

 
   
    public void registrarCliente() {
        FacesContext fc = FacesContext.getCurrentInstance();
       this.cliente.setEndereço(this.endereço); 
       this.clientModel.cadastrarCliente(this.cliente);
       this.cliente = new Cliente();
       this.endereço= new Endereço();
        fc.addMessage(null, new FacesMessage("Cliente cadastrado com sucesso!"));  
    }   
    public void removerCliente() {
       // this.clientModel.removerCliente(this.selectedCliente);
    }
    
    public void alterarCliente() {
      this.clientModel.alterarCliente(this.selectedCliente);
    }
    
    public Cliente recuperarID(String cliCpf) {
        return clientModel.recuperar(cliCpf);
    }
    @PostConstruct
    public void recuperarTodos() {
        
        try{
            ClienteModel clienteModel = new ClienteModel();
            Clientes = clienteModel.RecuperarTodos();
            
        }catch(RuntimeException erro){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("erro ao listar clientes"));
            erro.printStackTrace();
        }
        
    }

    public List<Cliente> getClientes() {
        return Clientes;
    }

    public void setClientes(List<Cliente> Clientes) {
        this.Clientes = Clientes;
    }

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

   
    
}

