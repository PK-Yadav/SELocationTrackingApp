package com.turvo.locationtracking.trackingdao.intf;

import com.turvo.locationtracking.entity.Vehicle;

public interface IVehicleDAO{
	/**
	 *
	 * @param vehicleId
	 * @return
	 */
	Vehicle getVehicleById(int vehicleId) throws Exception;

	/**
	 *
	 * @param vehicle
	 * @return
	 */
	void registerVehicle(Vehicle vehicle) throws Exception;
}