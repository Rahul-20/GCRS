package com.rainier.gc.system.gc.dto;

import com.rainier.gc.system.gc.model.StatusEnum;
import com.rainier.gc.system.gc.model.VehicleTypeEnum;

public class TruckCreationRequest 
{
	private String locationCode;
	private StatusEnum status;
	private String transportAgent;
	private String vehicleManufacturer;
	private String vehicleModel;
	private String vehicleName;
	private String vehicleNo;
	private VehicleTypeEnum vehicleType;
	private String typeOfBarcode;

	public String getTypeOfBarcode() {
		return typeOfBarcode;
	}
	public void setTypeOfBarcode(String typeOfBarcode) {
		this.typeOfBarcode = typeOfBarcode;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public String getTransportAgent() {
		return transportAgent;
	}
	public void setTransportAgent(String transportAgent) {
		this.transportAgent = transportAgent;
	}
	public String getVehicleManufacturer() {
		return vehicleManufacturer;
	}
	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public VehicleTypeEnum getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleTypeEnum vehicleType) {
		this.vehicleType = vehicleType;
	}
}