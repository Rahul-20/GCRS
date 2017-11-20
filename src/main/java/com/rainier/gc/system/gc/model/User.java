package com.rainier.gc.system.gc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.rainier.gc.system.gc.model.generic.GenericEntity;


/**
 * The persistent class for the USER database table.
 * 
 */


@Entity
@Table(name = "USER", schema=SchemaConstant.GC_APP_SCHEMA)
public class User  extends GenericEntity<Long, User>{

	private static final long serialVersionUID = 8755799199503489635L;

	@Id
	@Column(name = "USER_ID", unique=true, nullable=false)
	@TableGenerator(name = "TABLE_GEN", table = "GC_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
		pkColumnValue = "USER_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@Column(name="FIRST_NAME", length=60)	
	private String firstName;

	@Column(name="LAST_NAME", length=60)
	private String lastName;

	@Column(name="MOBILE_NUMBER", length=20)
	private String mobileNumber;

	@Column(name="CUSTOMER_PASSWORD", length=60)
	private String password;

	@Column(name="STATUS",nullable=false)
	@Enumerated(value = EnumType.STRING)
	private StatusEnum status;

/*	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USERS_GROUPS", schema=SchemaConstant.GC_APP_SCHEMA, joinColumns = { 
			@JoinColumn(name = "USER_ID", nullable = false, updatable = false) }
			, 
			inverseJoinColumns = { @JoinColumn(name = "GROUP_ID", 
					nullable = false, updatable = false) }
	)
	private Set<Group> groups = new HashSet<Group>();
*/	
	
	@Email
	@NotEmpty
	@Column(name="EMAIL_ADDRESS", length=96, nullable=false)
	private String emailAddress;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_ACCESS")
	private Date lastAccess;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_ACCESS")
	private Date loginTime;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}


	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User() {
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}