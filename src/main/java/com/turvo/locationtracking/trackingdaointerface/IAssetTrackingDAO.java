package com.turvo.locationtracking.trackingdaointerface;

import com.turvo.locationtracking.datacontract.AssetTrackingRecord;

import java.util.Date;
import java.util.List;

/**
 * This is dao interface for AssettrackingRecord table, will provide all dao calls methods related to table
 *
 * @author pappuy
 * @version 1.0
 */

public interface IAssetTrackingDAO{

	/**
	 *
	 * @param deviceId
	 * @param driverId
	 * @param assetType
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<AssetTrackingRecord> getAssetTrackingRecordBy(String deviceId, int driverId, String assetType, Date startDate, Date endDate) throws Exception;

	/**
	 *
	 * @param assetTrackingRecord
	 * @return
	 */
	void addTrackingRecord(AssetTrackingRecord assetTrackingRecord) throws Exception;
}