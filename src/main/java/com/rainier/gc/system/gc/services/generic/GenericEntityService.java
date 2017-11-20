package com.rainier.gc.system.gc.services.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.rainier.gc.system.gc.model.generic.GenericEntity;

/**
 * GenericEntity 
 */
public interface GenericEntityService<K extends Serializable & Comparable<K>, E extends GenericEntity<K, ?>>  {

	/**
	 * save method
	 * @param entity entity
	 */
	void save(E entity) throws ServiceException;
	
	/**
	 * update method 
	 * @param entity entity
	 */
	void update(E entity) throws ServiceException;
	
	/**
	 * create method
	 * @param entity entité
	 */
	void create(E entity) throws ServiceException;

	/**
	 * delete method
	 * @param entity entity
	 */
	void delete(E entity) throws ServiceException;
	

	/**
	 * getById 
	 * @param id
	 * @return entity
	 */
	E getById(K id);
	
	/**
	 * list method
	 * @return list
	 */
	List<E> list();
	
	
	/**
	 * count 
	 * @return count of long
	 */
	Long count();
	
	/**
	 * flush 
	 */
	void flush();
	


}
