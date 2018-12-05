package felipe.id.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import felipe.id.model.Cliente;
import felipe.id.model.ClienteModel;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Iugner
 */
@ManagedBean
@RequestScoped
public class BeanLogin {
    private List<Cliente>clientes;
    private String codigo;
    private String senha;
    private String login;

    public BeanLogin(String codigo, String senha, String login) {
        this.codigo = codigo;
        this.senha = senha;
        this.login = login;
    }
     
     public BeanLogin(){
        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    
    /**
     * Creates a new instance of BeanLogin
     */
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void inicio() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("template.xhtml");
    }
    /*
    public void cadastroCliente() throws IOException{
         FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("CadastroCliente.xhtml");
    }
    public void cadastroAnimal() throws IOException{
         FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("CadastrarAnimal.xhtml");
    }
    public void cadastroCanil() throws IOException{
         FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("CadastrarCanil.xhtml");
    }*/
    public void cadastroColaborador() throws IOException{
         FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("cadastrarColaborador.xhtml");
    }
     public void cadastroCliente() throws IOException{
         FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("cadastroCliente.xhtml");
    }
     public void codigo() throws IOException{
         FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("código.xhtml");
    }
      public void codigologin() throws IOException{
         FacesContext context = FacesContext.getCurrentInstance();
         if(this.codigo.equals("1998")){
             context.getExternalContext().redirect("menuAdministrador.xhtml");
         }
        
    }
       public void login() throws IOException{
         FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("login.xhtml");
    }
       
      public void logar(){
        FacesContext fc = FacesContext.getCurrentInstance();
        ClienteModel cm= new ClienteModel();
        
        
       clientes = cm.RecuperarTodos();
        
        for(Cliente c : clientes){
            
            if(this.login.equals( c.getLogin()) && this.senha.equals( c.getSenha())){
                 try{ 
                 fc.getExternalContext().redirect("menuCliente.xhtml");
                 
             }catch(IOException e){
                 e.printStackTrace();
                 
             }
             
                
            }else{  
                fc.addMessage(null,new FacesMessage("A autenticação falhou !")); 
              fc.getExternalContext().getSessionMap().put("user",login);
             fc.getExternalContext().getSessionMap().put("perfil","login");
          
        }
      }              
        
    }
      }
      
      

