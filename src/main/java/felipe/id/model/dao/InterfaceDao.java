/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model.dao;

import java.util.List;

/**
 *
 * @author Felipe
 */
public interface InterfaceDao <T>{
    
     public T inserir(T t);
     public void alterar(T t);
     public T recuperar(String t);
     public  void deletar(Integer t);
     public List<T> listarTodos();
  
}
