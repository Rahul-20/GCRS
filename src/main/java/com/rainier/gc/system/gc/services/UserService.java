package com.rainier.gc.system.gc.services;

import java.util.List;

import com.rainier.gc.system.gc.exception.ServiceException;
import com.rainier.gc.system.gc.model.User;
import com.rainier.gc.system.gc.services.generic.GenericEntityService;

public interface UserService extends GenericEntityService<Long, User> {

	User getByUserFirstName(String userFirstName) throws ServiceException;

	List<User> listUser() throws ServiceException;
	
	/**
	 * Create or update a User
	 * @param user
	 * @throws ServiceException
	 */
	void saveOrUpdate(User user) throws ServiceException;

	User getByEmail(String email);

}
