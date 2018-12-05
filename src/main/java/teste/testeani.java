/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import felipe.id.model.Animal;
import felipe.id.model.AnimalModel;
import felipe.id.model.Canil;
import felipe.id.model.Cliente;
import felipe.id.repositorioJpa.AnimalHibernateDAO;

/**
 *
 * @author Felipe
 */
public class testeani {
    
    public static void main(String [] args){
        
       
        AnimalModel am= new AnimalModel ();
        
        Canil can= new Canil();
            can.setIdcanil(6);
               
        
       // Cliente client = new Cliente();
        //client.setIdCli(3);
        
        Animal ani = new Animal("14","ercules",5,"Médio", "Pastor","dog","02/07/2018","02/07/2018",null,can); 
			
        
        
       
          am.cadastrarAnimal(ani);
        // ani.setIdAnimal(10);
         //am.alterarAnimal(ani);
        
    }
    
    
}
