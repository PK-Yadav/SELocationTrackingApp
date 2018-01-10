package com.turvo.locationtracking.controller;

import com.google.gson.Gson;
import com.turvo.locationtracking.controllerinterface.IDriverController;
import com.turvo.locationtracking.datacontract.Driver;
import com.turvo.locationtracking.trackingdaointerface.IDriverDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * This is Driver controller class which has implemented IDriverController interface
 *
 * @author pappuy
 * @version 1.0
 */
@Service("driverController")
public class DriverController implements IDriverController{

	@Qualifier("driverDAO")
	@Autowired
	private IDriverDAO driverDAO;


	@Override
	public Driver getDriverById(int id){
		return driverDAO.getDriverById(id);
	}

	@Override
	public void registerDriver(Driver driver){
		driverDAO.registerDriver(driver);

	}
}