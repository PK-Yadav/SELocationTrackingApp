package com.turvo.locationtracking.datacontract;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * This is driver entity class for driver table from DB
 *
 * @author pappuy
 * @version 1.0
 */
@Entity
@Table(name = "Driver")
public class Driver implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "driver_id") private int driverId;

	@Column(name = "first_name") private String firstName;

	@Column(name = "last_name") private String lastName;

	@Column(name = "licence_number") private String licenceNumber;

	@Column(name = "mobile_number") private String mobileNumber;

	@Column(name = "entry_dt")
	private Date entryDt;

	public Date getEntryDt() {
		return entryDt;
	}

	public void setEntryDt(Date entryDt) {
		this.entryDt = entryDt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


}
