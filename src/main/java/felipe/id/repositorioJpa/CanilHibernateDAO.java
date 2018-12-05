/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.repositorioJpa;

import felipe.id.model.HibernateUtil;

import felipe.id.model.dao.InterfaceDao;
import felipe.id.model.Canil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Felipe
 */
public class CanilHibernateDAO implements InterfaceDao<Canil> {
	private EntityManager em;

	private static InterfaceDao instance;
	

        private CanilHibernateDAO(){
    
          }
        
        
	public static InterfaceDao getInstance() {

		if (instance == null) {
			instance = new CanilHibernateDAO();

		}
		return instance;
	}

	public Canil inserir(Canil canil) {
		em = HibernateUtil.getEntityManager();

		try {
			this.em.getTransaction().begin();
			this.em.persist(canil);

			this.em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("erro ao " + e);
			this.em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			this.em.close();
		}
		return canil;
	}

	

	public void alterar(Canil canil) {
		em = HibernateUtil.getEntityManager();

		try {
			this.em.getTransaction().begin();

			this.em.merge(canil);

			this.em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("erro ao " + e);
			this.em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			this.em.close();
		}

	}

	public Canil recuperar(String codCanil) {
		em = HibernateUtil.getEntityManager();

		Canil can = null;

		try {
			can = em.find(Canil.class, codCanil);

		} finally {
			em.close();
		}
		return can;

	}


	public void deletar(Integer id_canil) {
		
		em = HibernateUtil.getEntityManager();

		Canil can = em.find(Canil.class, id_canil);
		try {
			em.getTransaction().begin();
			em.remove(can);
			em.getTransaction().commit();
		} finally {
			em.close();
		}

	}

	public List<Canil> listarTodos() {
		em = HibernateUtil.getEntityManager();
		List<Canil> canis;

		try {
			TypedQuery<Canil> c = em.createQuery("from Canil", Canil.class);
			canis = c.getResultList();

		} catch (Exception e) {
			canis = new ArrayList();

		} finally {
			em.close();
		}
		return canis;

	}
}