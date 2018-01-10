package com.turvo.locationtracking.trackingdao;

import com.turvo.locationtracking.datacontract.AssetTrackingRecord;
import com.turvo.locationtracking.itrackingrepository.IAssetTrackingRepo;
import com.turvo.locationtracking.trackingdaointerface.IAssetTrackingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * This is dao class for AssettrackingRecord table, will control all dao calls related to table
 *
 * @author pappuy
 * @version 1.0
 */
@Transactional
@Service("assetTrackingDAO")
@Repository
public class AssetTrackingDAO implements IAssetTrackingDAO{

	@Autowired IAssetTrackingRepo assetTrackingRepo;

	public List<AssetTrackingRecord> getAssetTrackingRecordBy(String deviceId, int driverId, String assetType, Date startDate, Date endDate) throws Exception {
		return assetTrackingRepo.findByDeviceIdAndDriverIdAndAssetTypeAndTimeStampBetween(deviceId, driverId, assetType, startDate, endDate);
	}

	@Override public void addTrackingRecord(AssetTrackingRecord assetTrackingRecord) throws Exception {
		assetTrackingRepo.save(assetTrackingRecord);
	}
}