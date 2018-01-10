package com.turvo.locationtracking.datacontract;

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
@Table(name="ASSETTRACKINGRECORD")
public class AssetTrackingRecord implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "asset_tracking_id")
	private int assetTrackingId;

	@Column(name="device_id")
	private String deviceId;

	@Column(name="asset_type")
	private String assetType;

	@Column(name="speed")
	private double speed;

	@Column(name="current_latitude")
	private double currentLatitude;

	@Column(name="current_longitude")
	private double currentLongitude;

	@Column(name="additional_info")
	private String additionalInfo;

	@Column(name = "driver_id")
	private int driverId;

	@Column(name = "stored_time")
	private Date timeStamp;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		if(null != timeStamp) {
			this.timeStamp = timeStamp;
		}else{
			this.timeStamp = new Date();
		}
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getAssetTrackingId() {
		return assetTrackingId;
	}

	public void setAssetTrackingId(int assetTrackingId) {
		this.assetTrackingId = assetTrackingId;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public double getSpeed() {
		return speed;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public double getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public double getCurrentLongitude() {
		return currentLongitude;
	}

	public void setCurrentLongitude(double currentLongitude) {
		this.currentLongitude = currentLongitude;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}



}