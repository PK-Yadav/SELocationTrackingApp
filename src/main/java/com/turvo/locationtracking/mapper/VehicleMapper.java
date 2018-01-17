package com.turvo.locationtracking.mapper;

import com.turvo.locationtracking.dto.VehicleDTO;
import com.turvo.locationtracking.entity.Vehicle;

import java.util.Date;

/**
 * This is VehicleMapper class, to convert vehicle entity to DTO and vice versa
 *
 * @author pappuy
 * @version 1.0
 */

public class VehicleMapper{

	/**
	 *
	 * @param vehicle
	 * @return
	 */
	public static VehicleDTO convertVehicleToVehicleDTOForAssetRd(Vehicle vehicle){
		VehicleDTO vehicleDTO  = new VehicleDTO();
		vehicleDTO.setGpsDeviceId(vehicle.getGpsDeviceid());
		vehicleDTO.setRegYear(vehicle.getRegYear());
		vehicleDTO.setStartTime(vehicle.getStartDate());
		vehicleDTO.setVehicleId(vehicle.getVehicleId());
		vehicleDTO.setVehicleNumber(vehicle.getvNumber());
		vehicleDTO.setAssetTrackingRecordDTOs(
				AssetTrackingRecordMapper.convertAssetTrackingRecordsToAssetRdDTOsForVehicle(vehicle.getTrackingRecords()));
		return vehicleDTO;
	}

	/**
	 *
	 * @param vehicleDTO
	 * @return
	 */
	public static Vehicle convertVehicleDTOToVehicle(VehicleDTO vehicleDTO){
		Vehicle vehicle = new Vehicle();
		vehicle.setvNumber(vehicleDTO.getVehicleNumber());
		vehicle.setGpsDeviceid(vehicleDTO.getGpsDeviceId());
		vehicle.setRegYear(vehicleDTO.getRegYear());
		vehicle.setStartDate(new Date());
		return vehicle;
	}
}