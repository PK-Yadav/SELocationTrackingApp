package com.turvo.locationtracking.controller;

import com.google.gson.Gson;
import com.turvo.locationtracking.controllerinterface.IAssetTrackingRdController;
import com.turvo.locationtracking.datacontract.AssetTrackingRecord;
import com.turvo.locationtracking.trackingdaointerface.IAssetTrackingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * This is Asset tracking controller class which has implemented IAssetTrackingRdController interface
 *
 * @author pappuy
 * @version 1.0
 */
@Service("assetTrackingRdController")
public class AssetTrackingRdController implements IAssetTrackingRdController{

	@Qualifier("assetTrackingDAO")
	@Autowired
	private IAssetTrackingDAO assetTrackingDAO;

	@Override public void storeTrackingRecord(AssetTrackingRecord assetTrackingRecord) throws Exception{
		assetTrackingDAO.addTrackingRecord(assetTrackingRecord);
	}

	public List<AssetTrackingRecord> getAssetTrackingRecordBy(String deviceId, int driverId, String assetType, long startTime, long endTime) throws Exception {
		return assetTrackingDAO.getAssetTrackingRecordBy(deviceId, driverId, assetType, new Date(startTime), new Date(endTime));
	}
}