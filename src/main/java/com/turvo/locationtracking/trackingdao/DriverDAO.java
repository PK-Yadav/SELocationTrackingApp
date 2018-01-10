package com.turvo.locationtracking.trackingdao;

import com.turvo.locationtracking.datacontract.Driver;
import com.turvo.locationtracking.itrackingrepository.IDriverRepo;
import com.turvo.locationtracking.trackingdaointerface.IDriverDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * This is dao class for Driver table, will control all dao calls related to table
 *
 * @author pappuy
 * @version 1.0
 */
@Transactional
@Qualifier("driverDAO")
@Repository
public class DriverDAO implements IDriverDAO {

	@Autowired
	private IDriverRepo driverRepo;

	@Override
	public void registerDriver(Driver driver) {
		driverRepo.save(driver);
	}

	@Override
	public Driver getDriverById(int driverId){
		return driverRepo.findByDriverId(driverId);
	}
}