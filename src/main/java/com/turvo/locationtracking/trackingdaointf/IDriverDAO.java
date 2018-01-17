package com.turvo.locationtracking.trackingdaointf;

import com.turvo.locationtracking.entity.Driver;

/**
 * This is dao interface for Driver table, will provide all dao calls methods related to table
 *
 * @author pappuy
 * @version 1.0
 */

public interface IDriverDAO{
	/**
	 *
	 * @param id
	 * @return
	 */
	Driver getDriverById(int id) throws Exception;

	/**
	 *
	 * @param driver
	 * @return
	 */
	void registerDriver(Driver driver) throws Exception;
}