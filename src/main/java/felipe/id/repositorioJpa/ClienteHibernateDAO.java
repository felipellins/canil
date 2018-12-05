package felipe.id.repositorioJpa;

import felipe.id.model.HibernateUtil;
import felipe.id.model.dao.ClienteDAO;
import felipe.id.model.Cliente;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Felipe
 */

public class ClienteHibernateDAO implements ClienteDAO<Cliente> {
   
     private  EntityManager em;

    private static ClienteDAO instance;
    private Cliente cli;  
    
     
    private ClienteHibernateDAO(){
        
    }
    
    
    
     public static ClienteDAO getInstance(){
    
      if(instance == null){
         instance = new ClienteHibernateDAO();
            
      }
      return instance; 
    } 
    @Override
    public Cliente inserir(Cliente cliente) {
      //esta com insert e delete
        
        em=HibernateUtil.getEntityManager();
        
        try{
            this.em.getTransaction().begin();
            this.em.persist(cliente);
            
           
            this.em.getTransaction().commit();
            
        }catch(Exception e){
            System.out.println("erro ao "+e);
            this.em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            this.em.close();
        }
          return cliente;
        }

    @Override
    public void alterarSenha(Cliente cliente) {
        // esta com insert e delete
        
        em=HibernateUtil.getEntityManager();
        
        try{
            this.em.getTransaction().begin();
            
            cliente= this.em.merge(cliente);
            
            this.em.getTransaction().commit();
            
        }catch(Exception e){
            System.out.println("erro ao "+e);
            this.em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            this.em.close();
        }
         
        
    }

    @Override
    public void alterar(Cliente cliente) {
      
        em=HibernateUtil.getEntityManager();
        
        try{
            this.em.getTransaction().begin();
            
            this.em.merge(cliente);
            
            this.em.getTransaction().commit();
            
        }catch(Exception e){
            System.out.println("erro ao "+e);
            this.em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            this.em.close();
        }
        
    }

    @Override
    public Cliente recuperar(String  cliCpf) {
      // certa 
        em=HibernateUtil.getEntityManager();
     
        Cliente cli = null;
        
        try{
            
            //retorn null
           //  cli =em.find(Cliente.class,cliCpf);
           //
    
//--------------
//        EntityManager entityManager = getEntityManager();
  //Query query = entityManager.createNamedQuery("Emprestimo.consultarTodosPorTituloLivro");

 // query.setParameter("titulo", tituloLivro);

  //return query.getResultList();
           
   //------------        
       
      Query q = em.createNamedQuery("cliente.consultarCliente"); 
         
            q.setParameter("clicpf",cliCpf); 
            //cli=em.find(Cliente.class, cliCpf);
            //cli = (Cliente) q.getResultList();
            
           return (Cliente) q.getSingleResult();
        }catch(Exception e){
            
            cli= new Cliente();
            
        }finally{
          em.close();
        }
      return cli;  
    }    
        
    

    @Override
    public void deletar(Integer idCli) {
        
        //certa
        em=HibernateUtil.getEntityManager();
     
        Cliente cli = em.find(Cliente.class,idCli);
         try{
         em.getTransaction().begin();
         em.remove(cli);
         em.getTransaction().commit();
         }finally{
          em.close();
         }        
            
    }

    @Override
    public List<Cliente> listarTodos() {
      //certa
        em=HibernateUtil.getEntityManager();
        List<Cliente>clientes;
       
        try{
             TypedQuery<Cliente> q = em.createQuery("from Cliente",Cliente.class);
             clientes = q.getResultList();
       
        }catch(Exception e){
            clientes= new ArrayList();
       
        }finally{
            em.close();
        }
        return clientes;
    
   
    } 
 

}

    

