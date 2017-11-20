package com.rainier.gc.system.gc.utils;

import java.util.Date;
import com.rainier.gc.system.gc.dto.TruckCreationRequest;
import com.rainier.gc.system.gc.model.Truck;

public class CreateTruckDataPopulator extends AbstractDataPopulator<TruckCreationRequest, Truck> {

	@Override
	public Truck populate(TruckCreationRequest source, Truck target)  {
		//BarCode bC = new BarCode(source.getBarCode());
		//target.setBarCode(bC); // set BarCode properties once generated.
		target.setLocationCode(source.getLocationCode());
		target.setStatus(source.getStatus());
		target.setTransportAgent(source.getTransportAgent());
		target.setUpdatedDate(new Date());
		target.setVehicleManufacturer(source.getVehicleManufacturer());
		target.setVehicleModel(source.getVehicleModel());
		target.setVehicleName(source.getVehicleName());
		target.setVehicleNo(source.getVehicleNo());
		target.setVehicleType(source.getVehicleType());
		return target;
	}

	@Override
	protected Truck createTarget() {
		return new Truck();
	}

}
