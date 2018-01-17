package com.turvo.locationtracking.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * This is driver entity class for driver table from DB
 *
 * @author pappuy
 * @version 1.0
 */
@Entity
@Table(name = "driver")
public class Driver implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "driver_id") private int driverId;

	@Column(name = "name") private String name;

	@Column(name = "address") private String address;

	@Column(name = "licence_number") private String licenceNumber;

	@Column(name = "mobile_number") private String mobileNumber;

	@Temporal(TemporalType.TIMESTAMP) @Column(name = "entry_dt") private Date entryDt;

	@OneToMany(mappedBy = "driver") private Set<AssetTrackingRecord> trackingRecords = new HashSet<>(0);

	public String getName() {
		return name;
	}

	public Set<AssetTrackingRecord> getTrackingRecords() {
		return trackingRecords;
	}

	public void setTrackingRecords(Set<AssetTrackingRecord> trackingRecords) {
		this.trackingRecords = trackingRecords;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEntryDt() {
		return entryDt;
	}

	public void setEntryDt(Date entryDt) {
		this.entryDt = entryDt;
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
