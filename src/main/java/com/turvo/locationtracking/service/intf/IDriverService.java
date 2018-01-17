package com.turvo.locationtracking.service.intf;

import com.google.gson.JsonObject;
import com.turvo.locationtracking.dto.DriverDTO;
import com.turvo.locationtracking.entity.Driver;

/**
 * This interface has methods to perform operation on Driver entity
 *
 * @author pappuy
 * @version 1.0
 */
public interface IDriverService {

	/**
	 * This method will return User/Driver details on the basis of id
	 *
	 * @param id
	 * @return
	 */
	Driver getDriverById(int id) throws Exception;

	/**
	 * This is used to parse the user details, and store it into DB
	 * @param driverDTO
	 * @return
	 * @throws Exception
	 */
	Driver registerDriver(DriverDTO driverDTO) throws Exception;
}