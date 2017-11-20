package com.rainier.gc.system.gc.dto;

import com.rainier.gc.system.gc.model.StatusEnum;
import com.rainier.gc.system.gc.model.VehicleTypeEnum;

public class TruckDTO {

	private Long id;
	//private String updatedDate;
	private String locationCode;
	private StatusEnum status;
	private String transportAgent;
	private String vehicleManufacturer;
	private String vehicleModel;
	private String vehicleName;
	private String vehicleNo;
	private VehicleTypeEnum vehicleType;
	private String barCode;
	//private String barCodeText;
	private String barCodeUrl;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}*/
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
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	/*public String getBarCodeText() {
		return barCodeText;
	}
	public void setBarCodeText(String barCodeText) {
		this.barCodeText = barCodeText;
	}*/
	public String getBarCodeUrl() {
		return barCodeUrl;
	}
	public void setBarCodeUrl(String barCodeUrl) {
		this.barCodeUrl = barCodeUrl;
	}
}