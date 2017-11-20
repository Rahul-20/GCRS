package com.rainier.gc.system.gc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rainier.gc.system.gc.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	//@Query("select u from User as u inner join fetch u.groups ug where u.firstName = ?1")
	@Query("select u from User as u  where u.firstName = ?1")
	User findByUserFirstName(String firstName);

	//@Query("select u from User as u inner join fetch u.groups ug where u.id = ?1")
	@Query("select u from User as u where u.id = ?1")
	User findOne(Long id);
	
	//@Query("select u from User as u inner join fetch u.groups ug order by u.id")
	@Query("select u from User as u order by u.id")
	List<User> findAll();
	
	//@Query("select u from User as u inner join fetch u.groups ug where u.emailAddress = ?1")
	@Query("select u from User as u  where u.emailAddress = ?1")
	User findByEmail(String email);
}
