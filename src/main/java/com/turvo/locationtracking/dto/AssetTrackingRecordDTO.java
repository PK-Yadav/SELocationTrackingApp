package com.turvo.locationtracking.dto;

/**
 * This is DTO file for AssetTrackingRecord entity, mainly used to communicate with server and and client for endpoint results.
 *
 * @author pappuy
 *  @version 1.0
 * @since   2018-01-16
 */


import java.util.Date;

public class AssetTrackingRecordDTO{
	private int assetTrackingRdId;
	private double longitude;
	private double latitude;
	private double speed;
	private String additionalInfo;
	private Date timeStamp;
	private int driverId;
	private int vehicleId;
	private VehicleDTO vehicleDTO;
	private DriverDTO driverDTO;
	private String assetType;

	public int getAssetTrackingRdId() {
		return assetTrackingRdId;
	}

	public void setAssetTrackingRdId(int assetTrackingRdId) {
		this.assetTrackingRdId = assetTrackingRdId;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getSpeed() {
		return speed;
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

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public VehicleDTO getVehicleDTO() {
		return vehicleDTO;
	}

	public void setVehicleDTO(VehicleDTO vehicleDTO) {
		this.vehicleDTO = vehicleDTO;
	}

	public DriverDTO getDriverDTO() {
		return driverDTO;
	}

	public void setDriverDTO(DriverDTO driverDTO) {
		this.driverDTO = driverDTO;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
}
