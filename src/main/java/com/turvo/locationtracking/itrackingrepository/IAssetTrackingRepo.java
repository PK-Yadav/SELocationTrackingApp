package com.turvo.locationtracking.itrackingrepository;

import com.turvo.locationtracking.entity.AssetTrackingRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Set;

/**
 * This is repository class to perform sql operation on AssetTrackingRecord table, with different criteria
 *
 * @author pappuy
 * @version 1.0
 */
public interface IAssetTrackingRepo extends CrudRepository<AssetTrackingRecord, Integer>{

	Set<AssetTrackingRecord> findByTimeStampBetweenAndDriver_DriverIdAndVehicle_VehicleId( Date startTime, Date endTime, int driverId, int vehicleId);
}