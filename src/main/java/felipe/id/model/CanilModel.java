/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model;

import felipe.id.repositorioJpa.CanilHibernateDAO;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class CanilModel {
    
             
       
       
        
	public void cadastrarCanil(Canil canil) {
	
             
            if(CanilHibernateDAO.getInstance().recuperar(canil.getCodCanil())== null){
                  
                CanilHibernateDAO.getInstance().inserir(canil);
        
               
	     }
        }
	public void alterarCanil(Canil canil) {
            
            if (CanilHibernateDAO.getInstance().recuperar(canil.getCodCanil())!= null) {
                  CanilHibernateDAO.getInstance().alterar(canil);
            }	
         }	


	public void removerCanil(Integer idcanil){
   
            if(idcanil != null){
                CanilHibernateDAO.getInstance().deletar(idcanil);
            }
                   
	
	}

	public Canil recuperar(String codCanil) {

		if (codCanil == null) {
			return null;
		}

		return (Canil) CanilHibernateDAO.getInstance().recuperar(codCanil);
	}

	public List<Canil> RecuperarTodos() {
		return CanilHibernateDAO.getInstance().listarTodos();
	}
        
}
