package com.rainier.gc.system.gc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rainier.gc.system.gc.model.Truck;

public interface TruckRepository extends JpaRepository<Truck, Long> {

	@Query("select t from Truck as t where t.barCode.barCode = ?1")
	Truck findByBarCode(String barCode);

}
