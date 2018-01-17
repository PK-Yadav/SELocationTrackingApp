package com.turvo.locationtracking.trackingdao.impl;

import com.turvo.locationtracking.entity.AssetTrackingRecord;
import com.turvo.locationtracking.itrackingrepository.IAssetTrackingRepo;
import com.turvo.locationtracking.trackingdao.intf.IAssetTrackingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Set;

/**
 * This is dao class for AssettrackingRecord table, will control all dao calls related to table
 *
 * @author pappuy
 * @version 1.0
 */
@Transactional
@Service("assetTrackingDAO")
public class AssetTrackingDAO implements IAssetTrackingDAO{

	@Autowired IAssetTrackingRepo assetTrackingRepo;

	public Set<AssetTrackingRecord> getAssetTrackingRecordBy(int vehicleId, int driverId, Date startDate, Date endDate) throws Exception {

		return assetTrackingRepo.findByTimeStampBetweenAndDriver_DriverIdAndVehicle_VehicleId(startDate, endDate, driverId, vehicleId);

	}

	@Override public void addTrackingRecord(AssetTrackingRecord assetTrackingRecord) throws Exception {
		assetTrackingRepo.save(assetTrackingRecord);
	}
}