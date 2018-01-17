package com.turvo.locationtracking.serviceimpl;

import com.google.gson.JsonObject;
import com.turvo.locationtracking.dto.DriverDTO;
import com.turvo.locationtracking.entity.Vehicle;
import com.turvo.locationtracking.mapper.DriverMapper;
import com.turvo.locationtracking.serviceintf.IDriverService;
import com.turvo.locationtracking.entity.Driver;
import com.turvo.locationtracking.trackingdaointf.IDriverDAO;
import com.turvo.locationtracking.trackingdaointf.IVehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * This is Driver serviceimpl class which has implemented IDriverService interface
 *
 * @author pappuy
 * @version 1.0
 */
@Service("driverService")
public class DriverService implements IDriverService {

	@Qualifier("driverDAO")
	@Autowired
	private IDriverDAO driverDAO;

	@Qualifier("vehicleDAO")
	@Autowired
	private IVehicleDAO vehicleDAO;


	@Override
	public Driver getDriverById(int id) throws Exception{
		return driverDAO.getDriverById(id);
	}

	@Override
	public Driver registerDriver(DriverDTO driverDTO) throws Exception{
		Driver driver = DriverMapper.convertDriverDTOtoDriver(driverDTO);
		driverDAO.registerDriver(driver);
		return driver;
	}


}