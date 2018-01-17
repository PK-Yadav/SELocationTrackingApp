package com.turvo.locationtracking.itrackingrepository;

import com.turvo.locationtracking.entity.Driver;
import org.springframework.data.repository.CrudRepository;

/**
 * This is repository class driver table, to perform sql operation on driver table with different criteria
 *
 * @author pappuy
 * @version 1.0
 * @since 2018-01-7
 *
 */
public interface IDriverRepo extends CrudRepository<Driver, Integer>{

	/**
	 * method to get driver details from DB
	 * @param driverId
	 * @return
	 */
	Driver findByDriverId(int driverId);

}