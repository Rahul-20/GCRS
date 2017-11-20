package com.rainier.gc.system.gc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rainier.gc.system.gc.model.generic.GenericEntity;

/**
 * The persistent class for the TRUCK database table.
 * 
 */

@Entity
@Table(name = "TRUCK", schema=SchemaConstant.GC_APP_SCHEMA)
public class Truck  extends GenericEntity<Long, Truck>{

	private static final long serialVersionUID = 8755799199503489635L;

	@Id
	@Column(name = "TRUCK_ID", unique=true, nullable=false)
	@TableGenerator(name = "TABLE_GEN", table = "GC_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
	pkColumnValue = "TRUCK_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;

	/*	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9_]*$")
	@Column(name = "UNIQE_IDENTIFIER", nullable=false, unique=true, length=100)
	private String uniqueIdentifier;
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE",nullable=false)
	private Date updatedDate;

	@Column(name="LOCATION_CODE",nullable=false, length=100)
	private String locationCode;

	/*	@Column(name="LATITUDE", length=100)
	private String latitude;

	@Column(name="LONGITUDE", length=100)
	private String longitude;
	 */
	@Column(name="STATUS",nullable=false)
	@Enumerated(value = EnumType.STRING)
	private StatusEnum status;

	@Column(name="TRANSPORT_AGENT", length=100)
	private String transportAgent;

	@Column(name="VEHICLE_MANUFACTURER", length=100)
	private String vehicleManufacturer;

	@Column(name="VEHICLE_MODEL", length=100)
	private String vehicleModel;

	@Column(name="VEHICLE_NAME", length=100)
	private String vehicleName;

	@Column(name="VEHICLE_NUMBER", length=100)
	private String vehicleNo;

	@Column(name="VEHICLE_TYPE",nullable=false, length=100)
	@Enumerated(value = EnumType.STRING)
	private VehicleTypeEnum vehicleType;

	@Column (name ="BAR_IMAGE", length=100)
	private String barCodeImage;

	@Column (name ="BAR_CODE", length=64)
	private String barCode;

	/*@Embedded
	BarCode barCode = null;*/

	public Truck() {
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getTransportAgent() {
		return this.transportAgent;
	}

	public void setTransportAgent(String transportAgent) {
		this.transportAgent = transportAgent;
	}


	public String getVehicleManufacturer() {
		return this.vehicleManufacturer;
	}

	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}

	public String getVehicleModel() {
		return this.vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleName() {
		return this.vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleNo() {
		return this.vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
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

	public VehicleTypeEnum getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleTypeEnum vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/*public BarCode getBarCode() {
		return barCode;
	}

	public void setBarCode(BarCode barCode) {
		this.barCode = barCode;
	}
	 */
	public String getBarCodeImage() {
		return barCodeImage;
	}

	public void setBarCodeImage(String barCodeImage) {
		this.barCodeImage = barCodeImage;
	}
}