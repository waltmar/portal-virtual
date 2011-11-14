/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.biopids.persistence;

import java.io.Serializable;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import javax.persistence.PersistenceContext;

import br.com.biopids.domain.EntityPersist;
import br.com.biopids.interfaces.IDAO;


/**
 * 
 * @author Johnys
 */
public abstract class GenericDAO<T, oid extends Serializable> implements
		IDAO<T, oid> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * public void setEntityManager(){ this.entityManager =
	 * entityManagerFactory.createEntityManager(); }
	 */

	public void save(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}
	
	
	public void update(T entity) {
		entityManager.merge(entity);
		entityManager.flush();
	}

	public void delete(T entity) {
		EntityPersist entityPersist = (EntityPersist) entity;
		entityManager.remove(entityManager.getReference(entity.getClass(),
				entityPersist.getCodigo()));
		entityManager.flush();
	}

	public List<T> getAll(T entity) {
		return entityManager.createQuery(
				"SELECT t from " + entity.getClass().getSimpleName() + " as t")
				.getResultList();

	}

	public List<T> getByFinger(T entity) {
		return null;
	}

	public List<T> getByFinder(T entity, String... colluns) {
		FinderObject<T> finder = new FinderObject<T>(entity);
		List<T> list = null;
		try {
			list = finder.getByFinder(this, colluns);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<T> getByFinder(T entity, String[] orders, String ...colluns){
		FinderObject<T> finder = new FinderObject<T>(entity);
		List<T> list = null;
		try {
			list = finder.getByFinder(this, orders, colluns);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		


	public T getByID(T entity, oid id) {
		return (T) entityManager.find(entity.getClass(), id);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Object[]> executeQuery(String query) {
		return entityManager.createQuery(query).getResultList();
	}

}
