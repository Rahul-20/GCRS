package com.rainier.gc.system.gc.utils;

import com.rainier.gc.system.gc.dto.TruckDTO;
import com.rainier.gc.system.gc.model.Truck;

public class ReadTruckDataPopulator extends AbstractDataPopulator<Truck	, TruckDTO> {

	@Override
	public TruckDTO populate(Truck source, TruckDTO target) {
		target.setId(source.getId());
		target.setBarCode(source.getBarCode());
		//target.setBarCodeText(source.getBarCode().getBarCodeText());
		target.setBarCodeUrl(source.getBarCodeImage());
		target.setLocationCode(source.getLocationCode());
		target.setStatus(source.getStatus());
		target.setTransportAgent(source.getTransportAgent());
		//target.setUpdatedDate(DateUtil.formatDate(source.getUpdatedDate()));
		target.setVehicleManufacturer(source.getVehicleManufacturer());
		target.setVehicleModel(source.getVehicleModel());
		target.setVehicleName(source.getVehicleName());
		target.setVehicleNo(source.getVehicleNo());
		target.setVehicleNo(source.getVehicleNo());
		target.setVehicleType(source.getVehicleType());
		return target;
	}

	@Override
	protected TruckDTO createTarget() {
		return new TruckDTO();
	}

}
