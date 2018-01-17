package com.turvo.locationtracking.itrackingrepository;

import com.turvo.locationtracking.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

/**
 * This is repository class vehicle table, to perform sql operation on driver table with different criteria
 *
 * @author pappuy
 * @version 1.0
 * @since 2018-01-16
 *
 */
public interface IVehicleRepository extends CrudRepository<Vehicle, Integer>{

	/**
	 * method to get vehicle details from DB
	 * @param vehicleId
	 * @return
	 */
	Vehicle findByVehicleId(int vehicleId);
}