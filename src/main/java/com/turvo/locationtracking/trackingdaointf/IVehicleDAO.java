package com.turvo.locationtracking.trackingdaointf;

import com.turvo.locationtracking.entity.Vehicle;

public interface IVehicleDAO{
	/**
	 *
	 * @param id
	 * @return
	 */
	Vehicle getVehicleById(int id) throws Exception;

	/**
	 *
	 * @param vehicle
	 * @return
	 */
	void registerVehicle(Vehicle vehicle) throws Exception;
}