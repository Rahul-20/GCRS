package com.rainier.gc.system.gc.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainier.gc.system.gc.exception.ServiceException;
import com.rainier.gc.system.gc.model.User;
import com.rainier.gc.system.gc.repositories.UserRepository;
import com.rainier.gc.system.gc.services.generic.GenericrEntityServiceImpl;

@Service
@Transactional
public class UserServiceImpl extends GenericrEntityServiceImpl<Long, User>
implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;
	}

	@Override
	public User getByUserFirstName(String userFirstName) throws ServiceException {
		LOGGER.debug("Fetching user by username");
		return userRepository.findByUserFirstName(userFirstName);
	}

	@Override
	public void delete(User user) {
		LOGGER.debug("Deleting User");
		User u = this.getById(user.getId());
		super.delete(u);
	}

	@Override
	public List<User> listUser() throws ServiceException {
		try {
			return userRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}


	@Override
	public void saveOrUpdate(User user) throws ServiceException {
		LOGGER.debug("save or upate user");
		userRepository.save(user);
	}

	@Override
	public User getByEmail(String email) {
		LOGGER.debug("Fetching user by email");
		return userRepository.findByEmail(email);
	}

}
