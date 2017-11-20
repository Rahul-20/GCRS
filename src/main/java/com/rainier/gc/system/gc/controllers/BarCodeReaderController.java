package com.rainier.gc.system.gc.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rainier.gc.system.gc.exception.BarCodeNoutFoundException;
import com.rainier.gc.system.gc.model.DustBin;
import com.rainier.gc.system.gc.model.Truck;
import com.rainier.gc.system.gc.services.DustBinService;
import com.rainier.gc.system.gc.services.TruckService;
import com.rainier.gc.system.gc.utils.ReadBinDataPopulator;
import com.rainier.gc.system.gc.utils.ReadTruckDataPopulator;

@RestController
public class BarCodeReaderController {

	@Autowired
	TruckService truckService;

	@Autowired
	DustBinService dustBinService;
	
	/**
	 * get Truck / Bin object based on barCode value.

	 * TKXXXXXXX - TRUCK
	 * 
	 * BNXXXXXXX - BIN
	 * @param barCode
	 * @return
	 * @throws BarCodeNoutFoundException 
	 */
	
	@GetMapping("/read-bar-code")
	public ResponseEntity<Map<String,Object>> getObject(@PathParam("barCode") String barCode) throws BarCodeNoutFoundException{
	//public Map<String,Object> getObject(@PathParam("barCode") String barCode) throws BarCodeNoutFoundException{
		Map<String,Object> response = new HashMap<String,Object>();
		if(StringUtils.isEmpty(barCode) || barCode.length() < 2){
			throw new BarCodeNoutFoundException("Invalid bar code");
		}
		Object responseValue = null;
		String barCodeType = barCode.substring(0,2);
		if("TK".equals(barCodeType)){
			Truck truck = truckService.findTruckByBarCode(barCode);
			ReadTruckDataPopulator populator = new ReadTruckDataPopulator();
			responseValue = populator.populate(truck);
			response.put("truckDetails", responseValue);
		}else if("BN".equals(barCodeType)){
			DustBin bin = dustBinService.findBinByBarCode(barCode);
			ReadBinDataPopulator populator = new ReadBinDataPopulator();
			responseValue = populator.populate(bin);
			response.put("binDetails", responseValue);
		}else {
			throw new BarCodeNoutFoundException("Invalid bar code type "+barCodeType);
		}
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		//return response;
	}
	
}
