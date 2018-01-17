package com.turvo.locationtracking.serviceintf;

import com.google.gson.JsonObject;
import com.turvo.locationtracking.dto.VehicleDTO;
import com.turvo.locationtracking.entity.Vehicle;

public interface IVehicleService {

	/**
	 *
	 * @param vehicleDTO
	 * @return
	 * @throws Exception
	 */
	Vehicle registerVehicle(VehicleDTO vehicleDTO) throws Exception;

	/**
	 *
	 * @param vehicleId
	 * @return
	 * @throws Exception
	 */
	VehicleDTO getVehicleById(int vehicleId) throws Exception;
}
