/*package com.rainier.gc.system.gc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainier.gc.system.gc.dto.GenericResponse;
import com.rainier.gc.system.gc.dto.TruckDTO;
import com.rainier.gc.system.gc.model.Truck;
import com.rainier.gc.system.gc.services.TruckService;
import com.rainier.gc.system.gc.utils.CreateTruckDataPopulator;

@RestController
public class TruckController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruckController.class);

	@Autowired
	TruckService truckService;
	
	@PostMapping("/truck")
	public ResponseEntity<GenericResponse> saveTruck(@RequestBody TruckDTO truckRequest){	
		LOGGER.debug("entering saveTruck request object "+truckRequest);
		GenericResponse response = new GenericResponse();
		CreateTruckDataPopulator populator = new CreateTruckDataPopulator();
		Truck  truck = populator.populate(truckRequest);
		truckService.save(truck);
		if(truck == null || org.springframework.util.StringUtils.isEmpty(truck.getId())){
			response.setCode(500);
			response.setId(null);
			response.setMessage("Could not creater truck object");
		}
		response.setCode(200);
		response.setId(truck.getId().toString());
		response.setMessage("Truck object created successfully , Object Id is "+truck.getId());
		LOGGER.debug("exiting saveTruck response object "+response);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}

}*/