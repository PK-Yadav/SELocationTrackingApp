package com.turvo.locationtracking.dto;

import java.util.Date;
import java.util.Set;

/**
 * This is DTO file for Vehilce entity, mainly used to communicate with server and and client for endpoint results.
 *
 * @author pappuy
 * @version 1.0
 * @since 2018-01-16
 */

public class VehicleDTO {

	private int                         vehicleId;
	private String                      vehicleNumber;
	private String                      regYear;
	private String                      gpsDeviceId;
	private Date                        startTime;
	private Set<AssetTrackingRecordDTO> assetTrackingRecordDTOs;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getRegYear() {
		return regYear;
	}

	public void setRegYear(String regYear) {
		this.regYear = regYear;
	}

	public String getGpsDeviceId() {
		return gpsDeviceId;
	}

	public void setGpsDeviceId(String gpsDeviceId) {
		this.gpsDeviceId = gpsDeviceId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Set<AssetTrackingRecordDTO> getAssetTrackingRecordDTOs() {
		return assetTrackingRecordDTOs;
	}

	public void setAssetTrackingRecordDTOs(Set<AssetTrackingRecordDTO> assetTrackingRecordDTOs) {
		this.assetTrackingRecordDTOs = assetTrackingRecordDTOs;
	}
}