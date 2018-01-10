package com.turvo.locationtracking.controllerinterface;

import com.turvo.locationtracking.datacontract.AssetTrackingRecord;

import java.util.Date;
import java.util.List;

/**
 * This interface have methods to store tracking data, fetch stored data....
 *
 * @author pappuy
 * @version 1.0
 */
public interface IAssetTrackingRdController{

	/**
	 *
	 * @param deviceId
	 * @param driverId
	 * @param assetType
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<AssetTrackingRecord> getAssetTrackingRecordBy(String deviceId, int driverId, String assetType, long startDate,
			long endDate) throws Exception;

	/**
	 *
	 * @param assetTrackingRecord
	 */
	void storeTrackingRecord(AssetTrackingRecord assetTrackingRecord) throws Exception;

}