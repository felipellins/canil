/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.repositorioJpa;

import felipe.id.model.HibernateUtil;
import felipe.id.model.dao.AnimalDAO;
import felipe.id.model.Animal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Felipe
 */
public class AnimalHibernateDAO implements AnimalDAO<Animal>{
	private EntityManager em;

	private static AnimalDAO instance;
	
        
        private AnimalHibernateDAO (){
            
        }
        
      
	public static AnimalDAO getInstance() {

		if (instance == null) {
			instance = new AnimalHibernateDAO();

		}
		return instance;
	}
	
	
	public Animal inserir(Animal animal) {
		em = HibernateUtil.getEntityManager();

		try {
			this.em.getTransaction().begin();
			this.em.persist(animal);

			this.em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("erro insirir ao" + e);
			this.em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			this.em.close();
		}
		return animal;
	}

	public void alterar(Animal animal) {
		em = HibernateUtil.getEntityManager();

		try {
			this.em.getTransaction().begin();

			this.em.merge(animal);

			this.em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("erro alterar ao" + e);
			this.em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			this.em.close();
		}

	}

	public Animal recuperar(String codAnimal) {
		em = HibernateUtil.getEntityManager();

		Animal ani = null;

		try {
			ani = em.find(Animal.class, codAnimal);

		} finally {
			em.close();
		}
		return ani;

	}

	public void deletar(Integer id_animal) {
		em = HibernateUtil.getEntityManager();

		Animal ani = em.find(Animal.class, id_animal);
		try {
			em.getTransaction().begin();
			em.remove(ani);
			em.getTransaction().commit();
		} finally {
			em.close();
		}

	}


	public List<Animal> listarTodos() {
		em = HibernateUtil.getEntityManager();
		List<Animal> animais;

		try {
			TypedQuery<Animal> a = em.createQuery("from Animal", Animal.class);
			animais = a.getResultList();

		} catch (Exception e) {
			animais = new ArrayList();

		} finally {
			em.close();
		}
		return animais;

	}


	public List<Animal> animaisOrfao() {
		
		em = HibernateUtil.getEntityManager();
		List<Animal> animais;

		try {
			TypedQuery<Animal> a = em.createQuery("from Animal where Cliente is null", Animal.class);
			animais = a.getResultList();

		} catch (Exception e) {
			animais = new ArrayList();

		} finally {
			em.close();
		}
		return animais;

	}

    @Override
    public Animal adotar(Animal animal) {
        
    try {
			this.em.getTransaction().begin();
			this.em.persist(animal);

			this.em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("erro insirir ao adotar" + e);
			this.em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			this.em.close();
		}
		return animal;
	}    
    
}

