package com.turvo.locationtracking.trackingdaointerface;

import com.turvo.locationtracking.datacontract.Driver;

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
	Driver getDriverById(int id);

	/**
	 *
	 * @param driver
	 * @return
	 */
	void registerDriver(Driver driver);
}