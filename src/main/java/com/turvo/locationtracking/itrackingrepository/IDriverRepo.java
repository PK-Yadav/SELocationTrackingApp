package com.turvo.locationtracking.itrackingrepository;

import com.turvo.locationtracking.datacontract.Driver;
import org.springframework.data.repository.CrudRepository;

/**
 * This is repository class driver table, to perform sql operation on driver table with different criteria
 */
public interface IDriverRepo extends CrudRepository<Driver, Integer>{

	/**
	 * method to get driver details from DB
	 * @param driverId
	 * @return
	 */
	Driver findByDriverId(int driverId);

}