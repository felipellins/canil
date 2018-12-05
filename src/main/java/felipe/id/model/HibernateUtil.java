/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author Felipe
 */
public class HibernateUtil {
    
    private static EntityManagerFactory emf;
    private EntityManager em;
    
    
    public static EntityManager getEntityManager(){
    
      if(emf == null){
          emf = Persistence.createEntityManagerFactory("felipe.id_mavem_war_1.0PU");
      }  
     return emf.createEntityManager();
    
    }
    
    
    
    
}
