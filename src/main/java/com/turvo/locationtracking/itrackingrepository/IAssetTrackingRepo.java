package com.turvo.locationtracking.itrackingrepository;

import com.turvo.locationtracking.datacontract.AssetTrackingRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * This is repository class to perform sql operation on AssetTrackingRecord table, with different criteria
 *
 * @author pappuy
 * @version 1.0
 */
public interface IAssetTrackingRepo extends CrudRepository<AssetTrackingRecord, Integer>{

	/**
	 *
	 * @param deviceId
	 * @param driverId
	 * @param assetType
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<AssetTrackingRecord> findByDeviceIdAndDriverIdAndAssetTypeAndTimeStampBetween(String deviceId, int driverId, String assetType, Date startDate, Date endDate);

}