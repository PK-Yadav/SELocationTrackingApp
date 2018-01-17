package com.turvo.locationtracking.service.impl;

import com.turvo.locationtracking.dto.DriverDTO;
import com.turvo.locationtracking.mapper.DriverMapper;
import com.turvo.locationtracking.service.intf.IDriverService;
import com.turvo.locationtracking.entity.Driver;
import com.turvo.locationtracking.trackingdao.intf.IDriverDAO;
import com.turvo.locationtracking.trackingdao.intf.IVehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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