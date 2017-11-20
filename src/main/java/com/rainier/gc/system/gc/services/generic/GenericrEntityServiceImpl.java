package com.rainier.gc.system.gc.services.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rainier.gc.system.gc.model.generic.GenericEntity;

/**
 * every service class must implement this generic service.
 * @param <T> entity type
 */
public abstract class GenericrEntityServiceImpl<K extends Serializable & Comparable<K>, E extends GenericEntity<K, ?>>
	implements GenericEntityService<K, E> {
	
	private Class<E> objectClass;

    private JpaRepository<E, K> repository;

	@SuppressWarnings("unchecked")
	public GenericrEntityServiceImpl(JpaRepository<E, K> repository) {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.objectClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
		this.repository = repository;
	}
	
	protected final Class<E> getObjectClass() {
		return objectClass;
	}

	public E getById(K id) {
		return repository.findOne(id);
	}

	public void save(E entity) throws ServiceException {
		repository.saveAndFlush(entity);
	}
	
	public void create(E entity) throws ServiceException {
		save(entity);
	}

	public void update(E entity) throws ServiceException {
		save(entity);
	}

	public void delete(E entity) throws ServiceException {
		repository.delete(entity);
	}
	
	public void flush() {
		repository.flush();
	}
	
	public List<E> list() {
		return repository.findAll();
	}

	public Long count() {
		return repository.count();
	}
}