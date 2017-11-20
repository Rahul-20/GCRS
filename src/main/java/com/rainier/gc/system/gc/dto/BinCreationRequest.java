package com.rainier.gc.system.gc.dto;

import com.rainier.gc.system.gc.model.BinTypeEnum;
import com.rainier.gc.system.gc.model.StatusEnum;
import com.rainier.gc.system.gc.model.WasteTypeEnum;

public class BinCreationRequest {
	
	private StatusEnum status;
	private BinTypeEnum binType;
	private WasteTypeEnum wasteType;
	private String wasteOrigin;
	private String binManufacturer;
	private String binModel;
	private Double binCapacity;
	private Integer serviceFrequency;
	private String installedDate;
	private String decommissionedDate;
	private String lastServiceDate;
	private String nextServiceDate;
	private String physicalAddress;
	private String email;
	private String latitude;
	private String longitude;
	private String locationDescription;
	private String notes;
	private String transporter;
	private String wasteGenerator;
	private String typeOfBarcode;

	public String getTypeOfBarcode() {
		return typeOfBarcode;
	}
	public void setTypeOfBarcode(String typeOfBarcode) {
		this.typeOfBarcode = typeOfBarcode;
	}
	
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public BinTypeEnum getBinType() {
		return binType;
	}
	public void setBinType(BinTypeEnum binType) {
		this.binType = binType;
	}
	public WasteTypeEnum getWasteType() {
		return wasteType;
	}
	public void setWasteType(WasteTypeEnum wasteType) {
		this.wasteType = wasteType;
	}
	public String getWasteOrigin() {
		return wasteOrigin;
	}
	public void setWasteOrigin(String wasteOrigin) {
		this.wasteOrigin = wasteOrigin;
	}
	public String getBinManufacturer() {
		return binManufacturer;
	}
	public void setBinManufacturer(String binManufacturer) {
		this.binManufacturer = binManufacturer;
	}
	public String getBinModel() {
		return binModel;
	}
	public void setBinModel(String binModel) {
		this.binModel = binModel;
	}
	public Double getBinCapacity() {
		return binCapacity;
	}
	public void setBinCapacity(Double binCapacity) {
		this.binCapacity = binCapacity;
	}
	public Integer getServiceFrequency() {
		return serviceFrequency;
	}
	public void setServiceFrequency(Integer serviceFrequency) {
		this.serviceFrequency = serviceFrequency;
	}
	public String getInstalledDate() {
		return installedDate;
	}
	public void setInstalledDate(String installedDate) {
		this.installedDate = installedDate;
	}
	public String getDecommissionedDate() {
		return decommissionedDate;
	}
	public void setDecommissionedDate(String decommissionedDate) {
		this.decommissionedDate = decommissionedDate;
	}
	public String getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public String getNextServiceDate() {
		return nextServiceDate;
	}
	public void setNextServiceDate(String nextServiceDate) {
		this.nextServiceDate = nextServiceDate;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLocationDescription() {
		return locationDescription;
	}
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getTransporter() {
		return transporter;
	}
	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}
	public String getWasteGenerator() {
		return wasteGenerator;
	}
	public void setWasteGenerator(String wasteGenerator) {
		this.wasteGenerator = wasteGenerator;
	}
}
