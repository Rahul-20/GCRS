package com.rainier.gc.system.gc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rainier.gc.system.gc.dto.BarcodeGenerationResponse;
import com.rainier.gc.system.gc.dto.BinCreationRequest;
import com.rainier.gc.system.gc.dto.GenericResponse;
import com.rainier.gc.system.gc.dto.TruckCreationRequest;
import com.rainier.gc.system.gc.dto.TruckDTO;
import com.rainier.gc.system.gc.exception.ServiceException;
import com.rainier.gc.system.gc.model.DustBin;
import com.rainier.gc.system.gc.model.Truck;
import com.rainier.gc.system.gc.services.DustBinService;
import com.rainier.gc.system.gc.services.TruckService;
import com.rainier.gc.system.gc.utils.CreateBinDataPopulator;
import com.rainier.gc.system.gc.utils.CreateTruckDataPopulator;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	DustBinService dustBinService;

	@Autowired
	TruckService truckService;

	@PostMapping("/bin")
	public ResponseEntity<BarcodeGenerationResponse> saveBin(@RequestBody BinCreationRequest binRequest) throws ServiceException{	
		LOGGER.debug("Entering saveBin request object "+binRequest);
		BarcodeGenerationResponse response = new BarcodeGenerationResponse();
		CreateBinDataPopulator populator = new CreateBinDataPopulator();
		DustBin  bin = populator.populate(binRequest);
		System.out.println("Bin......"+bin);
		dustBinService.saveOrUpdate(bin,binRequest.getTypeOfBarcode());
		response.setCode(200);
		response.setId(bin.getId().toString());
		response.setMessage("Bin barcode generated successfully!!!");
		LOGGER.debug("Exiting saveBin response object "+response);
		return new ResponseEntity<BarcodeGenerationResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/truck")
	public ResponseEntity<BarcodeGenerationResponse> saveTruck(@RequestBody TruckCreationRequest truckRequest) throws ServiceException{	
		LOGGER.debug("entering saveTruck request object "+truckRequest);
		BarcodeGenerationResponse response = new BarcodeGenerationResponse();
		CreateTruckDataPopulator populator = new CreateTruckDataPopulator();
		Truck  truck = populator.populate(truckRequest);
		truckService.saveOrUpdate(truck,truckRequest.getTypeOfBarcode(),truckRequest.getVehicleNo());
		response.setCode(200);
		response.setId(truck.getId().toString());
		response.setMessage("Truck object created successfully , Object Id is "+truck.getId());
		LOGGER.debug("exiting saveTruck response object "+response);
		return new ResponseEntity<BarcodeGenerationResponse>(response, HttpStatus.OK);
	}
}