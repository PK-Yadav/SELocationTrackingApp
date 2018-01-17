package com.turvo.locationtracking.trackingdaoimpl;

import com.turvo.locationtracking.entity.Vehicle;
import com.turvo.locationtracking.itrackingrepository.IVehicleRepository;
import com.turvo.locationtracking.trackingdaointf.IVehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Qualifier("vehicleDAO")
@Repository
public class VehicleDAO implements IVehicleDAO{

	@Autowired
	private IVehicleRepository vehicleRepository;

	@Override
	public Vehicle getVehicleById(int vehicleId) throws Exception{
		return vehicleRepository.findByVehicleId(vehicleId);
	}

	@Override
	public void registerVehicle(Vehicle vehicle) throws Exception{
		vehicleRepository.save(vehicle);
	}
}