package com.turvo.locationtracking.trackingdaoimpl;

import com.turvo.locationtracking.entity.Driver;
import com.turvo.locationtracking.itrackingrepository.IDriverRepo;
import com.turvo.locationtracking.trackingdaointf.IDriverDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * This is dao class for Driver table, will control all dao calls related to table
 *
 * @author pappuy
 * @version 1.0
 */
@Transactional
@Service("driverDAO")
public class DriverDAO implements IDriverDAO {

	@Autowired
	private IDriverRepo driverRepo;

	@Override
	public void registerDriver(Driver driver) throws Exception{
		driverRepo.save(driver);
	}

	@Override
	public Driver getDriverById(int driverId){
		return driverRepo.findByDriverId(driverId);
	}
}