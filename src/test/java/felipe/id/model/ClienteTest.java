/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 *
 * @author Felipe
 */
public class ClienteTest {
    
         Endereço endi= new Endereço ( "palmeirina","rua joão", 5,"pernambuco");
         Cliente c1 = new Cliente("155","Lins","@gmail","senha",endi);
         Cliente c2 = new Cliente("156","Lins","@1gmail","s11nha",endi); 
         Cliente c4 = new Cliente("157","lipe","@1gmail","s11nha",endi); 
    
   
                 
    @Test
    public void naoIguais() {
       assertNotEquals(c1,c4);
        
    }
    @Test
     public void iguais() {
       assertEquals(c1.getNome(),c2.getNome());
        
    }
     @Test
      public void naoNulo(){
         
         // nao pode ser nulo
         assertNotNull(c1.getNome());
         
            
     }
       @Test
       public void simNulo(){
         
         // tem que ser  nulo
         
         assertNull(null);
         
            
     }
      
      
      
}
