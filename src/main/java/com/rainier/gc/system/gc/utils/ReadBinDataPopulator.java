package com.rainier.gc.system.gc.utils;

import com.rainier.gc.system.gc.dto.BinDTO;
import com.rainier.gc.system.gc.model.DustBin;

public class ReadBinDataPopulator extends AbstractDataPopulator<DustBin, BinDTO> {

	@Override
	public BinDTO populate(DustBin source, BinDTO target)  {
		target.setId(source.getId());
		target.setBarCode(source.getBarCode());
		//target.setBarCodeText(source.getBarCode().getBarCodeText());
		//target.setBarCodeUrl(source.getBarCode().getBarCodeImage());
		target.setBarCodeUrl(source.getBarCodeImage());
		target.setBinCapacity(source.getBinCapacity());
		target.setBinManufacturer(source.getBinManufacturer());
		target.setBinModel(source.getBinModel());
		target.setBinType(source.getBinType());
		target.setDecommissionedDate(DateUtil.formatDate(source.getDecommissionedDate()));
		target.setEmail(source.getEmail());
		target.setInstalledDate(DateUtil.formatDate(source.getInstalledDate()));
		target.setLastServiceDate(DateUtil.formatDate(source.getLastServiceDate()));
		target.setLatitude(source.getLatitude());
		target.setLongitude(source.getLongitude());
		target.setLocationDescription(source.getLocationDescription());
		target.setNextServiceDate(DateUtil.formatDate(source.getNextServiceDate()));
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
	protected BinDTO createTarget() {
		return new BinDTO();
	}
}
