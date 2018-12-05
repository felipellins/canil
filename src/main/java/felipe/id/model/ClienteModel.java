/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model;

import felipe.id.model.dao.ClienteDAO;
import felipe.id.model.dao.InterfaceDao;
import felipe.id.repositorioJpa.ClienteHibernateDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Felipe
 */
public class ClienteModel {
   
     ClienteDAO<Cliente> dao = ClienteHibernateDAO.getInstance();
    
  public void cadastrarCliente(Cliente cliente) {
      
      if(ClienteHibernateDAO.getInstance().recuperar(cliente.getCliCpf())== null){
            
        dao.inserir(cliente);
      
      }else {
         	 
        }
       
  } 
   public void alterarCliente(Cliente cliente) {
        if ( ClienteHibernateDAO.getInstance().recuperar(cliente.getCliCpf())!= null) {
          
            ClienteHibernateDAO.getInstance().alterar(cliente);
        }
    }

    public void removerCliente(Integer  idCli) {
      
       
        if (idCli != null){
        ClienteHibernateDAO.getInstance().deletar(idCli);
        }
    
    }

    public Cliente recuperar(String cliCpf) {
        
        if ( cliCpf == null) {
            return null;
        }
        
        return (Cliente)(ClienteHibernateDAO.getInstance().recuperar(cliCpf)); 
    }

    public List<Cliente> RecuperarTodos() {
        return ClienteHibernateDAO.getInstance().listarTodos();
    }
 

}
