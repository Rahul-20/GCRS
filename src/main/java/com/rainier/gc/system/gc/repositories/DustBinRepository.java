package com.rainier.gc.system.gc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rainier.gc.system.gc.model.DustBin;
import com.rainier.gc.system.gc.model.Truck;

public interface DustBinRepository extends JpaRepository<DustBin, Long> {

	@Query("select bin from DustBin as bin where bin.barCode.barCode = ?1")
	DustBin findByBarCode(String barCode);
}
