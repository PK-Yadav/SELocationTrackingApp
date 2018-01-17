package com.turvo.locationtracking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * This is entity class for AssetTrackingRecord table from DB
 *
 * @author  pappuy
 * @version 1.0
 * @since   2018-01-05
 */

@Entity
@Table(name="asset_tracking_record")
public class AssetTrackingRecord implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tracking_id")
	private int assetTrackingId;

	@Column(name="vehicle_speed")
	private double vSpeed;

	@Column(name="latitude")
	private double latitude;

	@Column(name="longitude")
	private double longitude;

	@Column(name="additional_info")
	private String additionalInfo;

	@Column(name = "asset_type")
	private String assetType;

	@JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnore
	private Driver driver;

	@JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnore
	private Vehicle vehicle;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "track_time") private Date timeStamp;


	 public Driver getDriver() {
		return driver;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public int getAssetTrackingId() {
		return assetTrackingId;
	}

	public void setAssetTrackingId(int assetTrackingId) {
		this.assetTrackingId = assetTrackingId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public double getvSpeed() {
		return vSpeed;
	}

	public void setvSpeed(double vSpeed) {
		this.vSpeed = vSpeed;
	}
}