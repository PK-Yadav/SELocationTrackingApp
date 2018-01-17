package com.turvo.locationtracking.trackingdao.impl;

import com.turvo.locationtracking.entity.Vehicle;
import com.turvo.locationtracking.itrackingrepository.IVehicleRepository;
import com.turvo.locationtracking.trackingdao.intf.IVehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("vehicleDAO")
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