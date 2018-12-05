/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import felipe.id.model.Canil;
import felipe.id.model.Cliente;
import felipe.id.model.Colaborador;
import felipe.id.model.ColaboradorModel;
import felipe.id.model.Endereço;
import felipe.id.repositorioJpa.ColaboradorHibernateDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Felipe
 */
public class teste2 {
    
    
    public static void main(String [] args){
        
                 ColaboradorModel colm = new ColaboradorModel();
		 Endereço end= new Endereço ( "palmeiras","rua ", 4,"pe"); 
		
		 // ja possui dois canis cadastrado
		 // passo o id deles
		 Canil can= new Canil();
	         can.setIdcanil(6);
	         Canil can2= new Canil();
	         can2.setIdcanil(7);
	     
	      //coloco em uma lista de canis
	      List<Canil>canis= new ArrayList();
	       canis.add(can);
	       canis.add(can2);
	      
	       // criu um colaborador e coloco ele cadastrado nos
	       //dois canis
	      Colaborador col = new Colaborador ();
             col.setCpf("id_cpf");
             col.setLogin("login"); 
	     col.setSenha("senha");
	     col.setNomeCol("nome_col");
	     col.setEndereço(end);
	     col.setListaCanis(canis);
	     
             
              
               colm.cadastrarColaborador(col);
	     // colh.deletar("id_cpf");
		
        
        
        
    }
    
    
    
    
}
