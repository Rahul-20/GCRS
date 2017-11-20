package com.rainier.gc.system.gc.utils;

import com.rainier.gc.system.gc.dto.BinCreationRequest;
import com.rainier.gc.system.gc.model.BarCode;
import com.rainier.gc.system.gc.model.DustBin;

public class CreateBinDataPopulator extends AbstractDataPopulator<BinCreationRequest,DustBin> {

	@Override
	public DustBin populate(BinCreationRequest source,DustBin target)  {
		//BarCode bC = new BarCode(source.getBarCode());
		//target.setBarCode(bC);
		target.setBinCapacity(source.getBinCapacity());
		target.setBinManufacturer(source.getBinManufacturer());
		target.setBinModel(source.getBinModel());
		target.setBinType(source.getBinType());
		target.setDecommissionedDate(DateUtil.getDate(source.getDecommissionedDate()));
		target.setEmail(source.getEmail());
		target.setInstalledDate(DateUtil.getDate(source.getInstalledDate()));
		target.setLastServiceDate(DateUtil.getDate(source.getLastServiceDate()));
		target.setLatitude(source.getLatitude());
		target.setLocationDescription(source.getLocationDescription());
		target.setLongitude(source.getLongitude());
		target.setNextServiceDate(DateUtil.getDate(source.getNextServiceDate()));
		target.setNotes(source.getNotes());
		target.setPhysicalAddress(source.getPhysicalAddress());
		target.setServiceFrequency(source.getServiceFrequency());
		target.setStatus(source.getStatus());
		target.setTransporter(source.getTransporter());
		//target.setUniqueIdentifier(source.getUniqueIdentifier());
		target.setWasteGenerator(source.getWasteGenerator());
		target.setWasteOrigin(source.getWasteOrigin());
		target.setWasteType(source.getWasteType());
		return target;
	}

	@Override
	protected DustBin createTarget() {
		return new DustBin();
	}
}
