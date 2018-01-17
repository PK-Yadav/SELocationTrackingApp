package com.turvo.locationtracking.dto;

import java.util.Set;

/**
 * This is DTO file for Driver entity, mainly used to communicate with server and and client for endpoint results.
 *
 * @author pappuy
 * @version 1.0
 * @since 2018-01-16
 */

public class DriverDTO {

	private int                         driverId;
	private String                      name;
	private String                      address;
	private String                      licenceNumber;
	private String                      mobileNumber;
	private Set<AssetTrackingRecordDTO> assetTrackingRecordDTOs;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getName() {
		return name;
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

	public Set<AssetTrackingRecordDTO> getAssetTrackingRecordDTOs() {
		return assetTrackingRecordDTOs;
	}

	public void setAssetTrackingRecordDTOs(Set<AssetTrackingRecordDTO> assetTrackingRecordDTOs) {
		this.assetTrackingRecordDTOs = assetTrackingRecordDTOs;
	}
}