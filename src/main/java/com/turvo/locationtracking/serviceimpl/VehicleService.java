package com.turvo.locationtracking.serviceimpl;

import com.google.gson.JsonObject;
import com.turvo.locationtracking.dto.VehicleDTO;
import com.turvo.locationtracking.entity.Vehicle;
import com.turvo.locationtracking.mapper.VehicleMapper;
import com.turvo.locationtracking.serviceintf.IVehicleService;
import com.turvo.locationtracking.trackingdaointf.IDriverDAO;
import com.turvo.locationtracking.trackingdaointf.IVehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service("vehicleService")
public class VehicleService implements IVehicleService {

	@Autowired private IVehicleDAO vehicleDAO;

	@Autowired private IDriverDAO driverDAO;

	@Override
	public Vehicle registerVehicle(VehicleDTO vehicleDTO) throws Exception{
		Vehicle vehicle = VehicleMapper.convertVehicleDTOToVehicle(vehicleDTO);
		vehicleDAO.registerVehicle(vehicle);
		return vehicle;
	}

	@Override
	public VehicleDTO getVehicleById(int vehicleId) throws Exception {
		return  VehicleMapper.convertVehicleToVehicleDTOForAssetRd(vehicleDAO.getVehicleById(vehicleId));
	}


}