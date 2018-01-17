package com.turvo.locationtracking.mapper;

import com.turvo.locationtracking.dto.DriverDTO;
import com.turvo.locationtracking.entity.Driver;

import java.util.Date;

/**
 * This is DriverMapper class, to convert driver entity to DTO and vice versa
 *
 * @author pappuy
 * @version 1.0
 */


public  class DriverMapper{

	/**
	 *
	 * @param driver
	 * @return
	 */
	public static DriverDTO convertDriverIntoDriverDTOForAssetRd(Driver driver){
		DriverDTO driverDTO = new DriverDTO();
		driverDTO.setAddress(driver.getAddress());
		driverDTO.setDriverId(driver.getDriverId());
		driverDTO.setLicenceNumber(driver.getLicenceNumber());
		driverDTO.setMobileNumber(driver.getMobileNumber());
		return driverDTO;
	}

	/**
	 *
	 * @param driverDTO
	 * @return
	 */
	public static Driver convertDriverDTOtoDriver(DriverDTO driverDTO){
		Driver driver = new Driver();
		driver.setDriverId(driverDTO.getDriverId());
		driver.setEntryDt(new Date());
		driver.setAddress(driverDTO.getAddress());
		driver.setMobileNumber(driverDTO.getMobileNumber());
		driver.setLicenceNumber(driverDTO.getMobileNumber());
		driver.setName(driverDTO.getName());
		return driver;
	}

	public static DriverDTO conforDriverToDriverDTOForDriver(Driver driver){
		DriverDTO driverDTO = new DriverDTO();
		driverDTO.setAddress(driver.getAddress());
		driverDTO.setDriverId(driver.getDriverId());
		driverDTO.setLicenceNumber(driver.getLicenceNumber());
		driverDTO.setMobileNumber(driver.getMobileNumber());
		driverDTO.setAssetTrackingRecordDTOs(AssetTrackingRecordMapper.convertAssetTrackingRecordsToAssetRdDTOsForDriver(driver.getTrackingRecords()));
		return driverDTO;
	}
}