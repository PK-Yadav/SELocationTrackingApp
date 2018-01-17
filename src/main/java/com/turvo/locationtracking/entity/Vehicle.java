package com.turvo.locationtracking.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This is driver entity class for vehicle table from DB
 *
 * @author pappuy
 * @version 1.0
 */

@Table(name = "vehicle")
@Entity
public class Vehicle {

	@Id @Column(name = "vehicle_id") @GeneratedValue(strategy = GenerationType.AUTO) private int vehicleId;

	@Column(name = "vehicle_number") private String vNumber;

	// This will represent weather vehicle has gps or mobile tracking device .
	@Column(name = "gps_device_id") private String gpsDeviceid;

	@Column(name = "reg_year") private String regYear;

	@Temporal(TemporalType.TIMESTAMP) @Column(name = "start_date") private Date startDate;

	@OneToMany(mappedBy = "vehicle") private Set<AssetTrackingRecord> trackingRecords = new HashSet<>(0);

	public int getVehicleId() {
		return vehicleId;

	}

	public Set<AssetTrackingRecord> getTrackingRecords() {
		return trackingRecords;
	}

	public void setTrackingRecords(Set<AssetTrackingRecord> trackingRecords) {
		this.trackingRecords = trackingRecords;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getvNumber() {
		return vNumber;
	}

	public void setvNumber(String vNumber) {
		this.vNumber = vNumber;
	}

	public String getGpsDeviceid() {
		return gpsDeviceid;
	}

	public void setGpsDeviceid(String gpsDeviceid) {
		this.gpsDeviceid = gpsDeviceid;
	}

	public String getRegYear() {
		return regYear;
	}

	public void setRegYear(String regYear) {
		this.regYear = regYear;
	}

}