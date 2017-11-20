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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.rainier.gc.system.gc.model.generic.GenericEntity;

/**
 * The persistent class for the BIN database table.
 * 
 */

@Entity
@Table(name = "DUST_BIN", schema=SchemaConstant.GC_APP_SCHEMA)
public class DustBin  extends GenericEntity<Long, DustBin>{

	private static final long serialVersionUID = 8755799199503489635L;

	@Id
	@Column(name = "BIN_ID", unique=true, nullable=false)
	@TableGenerator(name = "TABLE_GEN", table = "GC_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
	pkColumnValue = "BIN_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;

	/*@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9_]*$")
	@Column(name = "UNIQE_IDENTIFIER", nullable=false, unique=true, length=100)
	private String uniqueIdentifier;*/

	@Column(name="STATUS",nullable=false)
	@Enumerated(value = EnumType.STRING)
	private StatusEnum status;

	@Column(name="BIN_TYPE",nullable=false)
	@Enumerated(value = EnumType.STRING)
	private BinTypeEnum binType;

	@Column(name="WASTE_TYPE",nullable=false)
	@Enumerated(value = EnumType.STRING)
	private WasteTypeEnum wasteType;

	@Column(name="WASTE_ORIGIN",nullable=false, length=100)
	private String wasteOrigin;

	@Column(name="BIN_MANUFACTURER",nullable=false, length=100)
	private String binManufacturer;

	@Column(name="BIN_MODEL",nullable=false, length=100)
	private String binModel;

	@Column(name="BIN_CAPACITY",nullable=false, length=100)
	private Double binCapacity;

	@Column(name="SERVICE_FREQUENCY",nullable=false)
	private Integer serviceFrequency;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSTALLED_DATE")
	private Date installedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DECOMMISSION_DATE")
	private Date decommissionedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_SERVICE_DATE")
	private Date lastServiceDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="NEXT_SERVICE_DATE")
	private Date nextServiceDate;

	@Column(name="PHY_ADDRESS")
	private String physicalAddress;

	@Email
	@NotEmpty
	@Column(name = "EMAIL", length=60, nullable=false)
	private String email;

	@Column(name="LATITUDE",length=100)
	private String latitude;

	@Column(name="LONGITUDE",length=100)
	private String longitude;

	/*	@Column(name="UNIQE_ID_CODE",length=100)
	private String uniqueIdentificationCode;
	 */
	@Column(name="LOCATION_DESCRIPTION",length=100)
	private String locationDescription;

	@Column(name="NOTES",length=200)
	private String notes;

	@Column(name="TRANSPORTER",length=100)
	private String transporter;

	@Column(name="WASTE_GENERATOR",length=100)
	private String wasteGenerator;

	@Column (name ="BAR_IMAGE", length=100)
	private String barCodeImage;
	
	@Column (name ="BAR_CODE", length=64)
	private String barCode;

	/*@Embedded
	private BarCode barCode = null;
*/
	public DustBin() {
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
	public String getBarCodeImage() {
		return barCodeImage;
	}

	public void setBarCodeImage(String barCodeImage) {
		this.barCodeImage = barCodeImage;
	}

	public Date getDecommissionedDate() {
		return this.decommissionedDate;
	}

	public void setDecommissionedDate(Date decommissionedDate) {
		this.decommissionedDate = decommissionedDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getInstalledDate() {
		return this.installedDate;
	}

	public void setInstalledDate(Date installedDate) {
		this.installedDate = installedDate;
	}

	public Date getLastServiceDate() {
		return this.lastServiceDate;
	}

	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	public String getLocationDescription() {
		return this.locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getNextServiceDate() {
		return this.nextServiceDate;
	}

	public void setNextServiceDate(Date nextServiceDate) {
		this.nextServiceDate = nextServiceDate;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhysicalAddress() {
		return this.physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}


	public String getTransporter() {
		return this.transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	/*public String getUniqueIdentifier() {
		return this.uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}
	 */
	
	public String getWasteGenerator() {
		return this.wasteGenerator;
	}

	public void setWasteGenerator(String wasteGenerator) {
		this.wasteGenerator = wasteGenerator;
	}

	public String getWasteOrigin() {
		return this.wasteOrigin;
	}

	public void setWasteOrigin(String wasteOrigin) {
		this.wasteOrigin = wasteOrigin;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/*public BarCode getBarCode() {
		return barCode;
	}

	public void setBarCode(BarCode barCode) {
		this.barCode = barCode;
	}*/
}