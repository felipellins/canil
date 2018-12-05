/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model;

import felipe.id.model.dao.AnimalDAO;
import felipe.id.model.dao.InterfaceDao;
import felipe.id.repositorioJpa.AnimalHibernateDAO;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class AnimalModel {
	
   AnimalDAO<Animal> dao = AnimalHibernateDAO.getInstance();
    

    
    public void cadastrarAnimal(Animal animal) {
		if (AnimalHibernateDAO.getInstance().recuperar(animal.getCodAnimal()) == null) {
		
                    dao.inserir(animal);
		}
                   
                

	}

	public void alterarAnimal(Animal animal) {
	        if ( AnimalHibernateDAO.getInstance().recuperar(animal.getCodAnimal())!= null) {
	            AnimalHibernateDAO.getInstance().alterar(animal);
	        }
	    }

	public Animal removerAnimal(Integer idAnimal) {
   
		
		if (idAnimal != null) {
			 AnimalHibernateDAO.getInstance().deletar(idAnimal);

		} 
		return null;
	}

	public Animal recuperar(String codAnimal) {

		if (codAnimal == null) {
			return null;
		}

		return (Animal) AnimalHibernateDAO.getInstance().recuperar(codAnimal);
	}

	public List<Animal> RecuperarTodos() {
		return AnimalHibernateDAO.getInstance().listarTodos();
	}
        public List<Animal>RecuperarOrfaos(){
            
            return AnimalHibernateDAO.getInstance().animaisOrfao();
        }

}
