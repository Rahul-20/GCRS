package com.rainier.gc.system.gc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainier.gc.system.gc.dto.BinDTO;
import com.rainier.gc.system.gc.dto.GenericResponse;
import com.rainier.gc.system.gc.model.DustBin;
import com.rainier.gc.system.gc.services.DustBinService;
import com.rainier.gc.system.gc.utils.CreateBinDataPopulator;

@RestController
public class BinController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BinController.class);
	@Autowired
	DustBinService dustBinService;

	/*@PostMapping("/bin")
	public ResponseEntity<GenericResponse> saveBin(@RequestBody BinDTO binRequest){	
		LOGGER.debug("entering saveTruck request object "+binRequest);
		GenericResponse response = new GenericResponse();
		CreateBinDataPopulator populator = new CreateBinDataPopulator();
		DustBin  bin = populator.populate(binRequest);
		dustBinService.save(bin);
		if(bin == null || org.springframework.util.StringUtils.isEmpty(bin.getId())){
			response.setCode(500);
			response.setId(null);
			response.setMessage("Could not creater Bin object");
		}
		response.setCode(200);
		response.setId(bin.getId().toString());
		response.setMessage("Bin object created successfully , Object Id is "+bin.getId());
		LOGGER.debug("exiting saveBin response object "+response);
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}
	 */
}
