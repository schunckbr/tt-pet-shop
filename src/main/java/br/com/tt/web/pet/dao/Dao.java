package br.com.tt.web.pet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.web.pet.model.Pet;

public class Dao {
	private EntityManager em() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pet_shop");
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public <T> void salvar(T entity) {
		EntityManager em = em();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public <T> List<T> buscarTodos(T entity) {
		EntityManager em = em();
		String entityClass = entity.getClass().getSimpleName();
		String consulta = "SELECT e FROM "+entityClass+" e";
		TypedQuery<T> query = (TypedQuery<T>) em.createQuery(consulta);

		List<T> resultList = query.getResultList();
		em.close();
		return resultList;

	}

}
