package com.turvo.locationtracking.service.intf;

import com.google.gson.JsonObject;
import com.turvo.locationtracking.dto.AssetTrackingRecordDTO;
import com.turvo.locationtracking.entity.AssetTrackingRecord;

import java.util.List;
import java.util.Set;

/**
 * This interface have methods to store tracking data, fetch stored data....
 *
 * @author pappuy
 * @version 1.0
 */
public interface IAssetTrackingRdService {

	/**
	 *
	 * @param vehicleId
	 * @param driverId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	Set<AssetTrackingRecordDTO> getAssetTrackingRecordBy(int vehicleId, int driverId, long startDate,
			long endDate) throws Exception;

	/**
	 *
	 * @param assetTrackingRecordDTO
	 */
	AssetTrackingRecord storeTrackingRecord(AssetTrackingRecordDTO assetTrackingRecordDTO) throws Exception;

}