package com.turvo.locationtracking.controllerinterface;

import com.turvo.locationtracking.datacontract.Driver;

/**
 * This interface has methods to perform operation on Driver entity
 *
 * @author pappuy
 * @version 1.0
 */
public interface IDriverController{

	/**
	 * This method will return User/Driver details on the basis of id
	 *
	 * @param id
	 * @return
	 */
	Driver getDriverById(int id);

	/**
	 * This is used to parse the user details, and store it into DB
	 * @param driver
	 * @return
	 */
	void registerDriver(Driver driver);
}