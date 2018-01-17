package com.turvo.locationtracking.trackingdaointf;

import com.turvo.locationtracking.entity.AssetTrackingRecord;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * This is dao interface for AssettrackingRecord table, will provide all dao calls methods related to table
 *
 * @author pappuy
 * @version 1.0
 */

public interface IAssetTrackingDAO{

	/**
	 *
	 * @param vehicleId
	 * @param driverId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Set<AssetTrackingRecord> getAssetTrackingRecordBy(int vehicleId, int driverId, Date startDate, Date endDate) throws Exception;

	/**
	 *
	 * @param assetTrackingRecord
	 * @return
	 */
	void addTrackingRecord(AssetTrackingRecord assetTrackingRecord) throws Exception;

}