package com.turvo.locationtracking.serviceimpl;

import com.turvo.locationtracking.dto.AssetTrackingRecordDTO;
import com.turvo.locationtracking.mapper.AssetTrackingRecordMapper;
import com.turvo.locationtracking.mapper.DriverMapper;
import com.turvo.locationtracking.serviceintf.IAssetTrackingRdService;
import com.turvo.locationtracking.entity.AssetTrackingRecord;
import com.turvo.locationtracking.trackingdaointf.IAssetTrackingDAO;
import com.turvo.locationtracking.trackingdaointf.IDriverDAO;
import com.turvo.locationtracking.trackingdaointf.IVehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is Asset tracking serviceimpl class which has implemented IAssetTrackingRdService interface
 *
 * @author pappuy
 * @version 1.0
 */
@Service("assetTrackingRdService")
public class AssetTrackingRdService implements IAssetTrackingRdService {

	@Qualifier("assetTrackingDAO")
	@Autowired
	private IAssetTrackingDAO assetTrackingDAO;

	@Qualifier("driverDAO")
	@Autowired
	private IDriverDAO driverDAO;

	@Qualifier("vehicleDAO")
	private IVehicleDAO vehicleDAO;

	@Override public AssetTrackingRecord storeTrackingRecord(AssetTrackingRecordDTO assetTrackingRecordDTO) throws Exception{
		AssetTrackingRecord assetTrackingRecord = AssetTrackingRecordMapper.convertAssetRdDTOToAssetTrackingRecord(assetTrackingRecordDTO);
		assetTrackingRecord.setDriver(driverDAO.getDriverById(assetTrackingRecordDTO.getDriverId()));
		assetTrackingRecord.setVehicle(vehicleDAO.getVehicleById(assetTrackingRecordDTO.getVehicleId()));
		assetTrackingDAO.addTrackingRecord(assetTrackingRecord);
		return  assetTrackingRecord;
	}

	public Set<AssetTrackingRecordDTO> getAssetTrackingRecordBy(int vehicleId, int driverId, long startTime, long endTime) throws Exception {
		 Set<AssetTrackingRecord> assetTrackingRecords = assetTrackingDAO.getAssetTrackingRecordBy(vehicleId, driverId, new Date(startTime), new Date(endTime));
		Set<AssetTrackingRecordDTO> assetTrackingRecordDTOs = new HashSet<>();
		for(AssetTrackingRecord assetTrackingRecord : assetTrackingRecords){
			assetTrackingRecordDTOs.add(AssetTrackingRecordMapper.convertAssetTrackingRecordToAssetRdDTO(assetTrackingRecord));
		}
		return assetTrackingRecordDTOs;
	}

}