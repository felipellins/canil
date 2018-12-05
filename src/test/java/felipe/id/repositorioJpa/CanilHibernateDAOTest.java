/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.repositorioJpa;

import felipe.id.model.Canil;
import felipe.id.model.CanilModel;
import felipe.id.model.Endereço;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Felipe
 */
public class CanilHibernateDAOTest {
    
  CanilModel cm= new CanilModel();
    
  private static Canil c1;
  private static Canil c2;
  private static Endereço endi;  
  private static Canil c3;
   
  @BeforeAll
    public void objetoIniciado(){
       
         endi= new Endereço ( "palmeirina","rua joão", 5,"pernambuco");
         c1 = new Canil("533","canil pe",endi,null);
         c2 = new Canil("534","canil pe",endi,null);  
         c3= new  Canil("535","nosso lar",endi,null);  
    }
    
    
    
    
    @Test
    public void inserir() {
        
        cm.cadastrarCanil(c1);
        
        assertEquals(c1,cm.recuperar("533"));
               
                
    }
    
     @Ignore
    public void delete(){
        
        cm.cadastrarCanil(c2);
        cm.removerCanil(534);
      
        // valor tem que ser nulo
         assertNull(cm.recuperar("534"));
        
    }
    
      @Ignore
    public void alterar(){
        
        cm.cadastrarCanil(c3);
        
        c3=  new  Canil("534","canil alterado",endi,null);  
        c3.setCodCanil("534");
        cm.alterarCanil(c3);
        
        assertEquals(c3,cm.recuperar("534"));
        
        
        
    }
    
      @Ignore
     public void recuperar(){
          // nao pode ser nulo
          assertNotNull(cm.recuperar("533"));
        
     }
    
      @Ignore
     public void iguais(){
        // iguais 
        assertEquals(c1.getNome(), c2.getNome());
        
        // não iguais
        assertNotEquals(cm.recuperar("533"),cm.recuperar("535"));  
         
     }
     
      @Ignore
     public void recuperarTodos(){
         
         // nao pode ser nulo
         assertNotNull(cm.RecuperarTodos());
        
         
     }
     
    
}

