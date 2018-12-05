/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.repositorioJpa;

import felipe.id.model.Cliente;
import felipe.id.model.ClienteModel;
import felipe.id.model.Endereço;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Felipe
 */
public class ClienteHibernateDAOTest {
    
   ClienteModel cm= new ClienteModel();
    
  private static Cliente c1;
  private static Cliente c2;
  private static Endereço endi;  
  private static Cliente c3;
   
  @BeforeAll
    public void objetoIniciado(){
       
         endi= new Endereço ( "palmeirina","rua joão", 5,"pernambuco");
         c1 = new Cliente("155","Lins","@gmail","senha",endi);
         c2 = new Cliente("156","Lins","@1gmail","s11nha",endi);  
         c3= new  Cliente("157","FelipeLins","@gmail","s11nha",endi);  
    }
    
    
    
    
    @Test
    public void inserir() {
        
        cm.cadastrarCliente(c1);
        
        assertEquals(c1,cm.recuperar("155"));
               
                
    }
    
     @Ignore
    public void delete(){
        
        cm.cadastrarCliente(c2);
        cm.removerCliente(156);
      
        // valor tem que ser nulo
         assertNull(cm.recuperar("156"));
        
    }
    
      @Ignore
    public void alterar(){
        
        cm.cadastrarCliente(c3);
        
        c3=  new  Cliente("157","Lins alterado","@1gmail","s11nha",endi);  
        c3.setCliCpf("157");
        cm.alterarCliente(c3);
        
        assertEquals(c3,cm.recuperar("157"));
        
        
        
    }
    
      @Ignore
     public void recuperar(){
          // nao pode ser nulo
          assertNotNull(cm.recuperar("155"));
        
     }
    
      @Ignore
     public void iguais(){
        // iguais 
        assertEquals(c1.getNome(), c2.getNome());
        
        // não iguais
        assertNotEquals(cm.recuperar("155"),cm.recuperar("157"));  
         
     }
     
      @Ignore
     public void recupetarTodos(){
         
         // nao pode ser nulo
         assertNotNull(cm.RecuperarTodos());
        
         
     }
     
    
}
