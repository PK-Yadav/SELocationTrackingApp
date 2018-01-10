package com.turvo.locationtracking.service;

import com.turvo.locationtracking.controllerinterface.IAssetTrackingRdController;
import com.turvo.locationtracking.controllerinterface.IDriverController;
import com.turvo.locationtracking.datacontract.AssetTrackingRecord;
import com.turvo.locationtracking.datacontract.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This is rest webservice class which has exposed rest url for client to performed their operations related to this
 * tracking application.
 *
 * @author pappuy
 * @version 1.0
 */
@RestController @RequestMapping("/api") public class SELocationTrackingService {

	@Qualifier("driverController") @Autowired IDriverController driverController;

	@Qualifier("assetTrackingRdController") @Autowired IAssetTrackingRdController assetTrackingRdcontroller;

	/**
	 * Rest url to get driver by id
	 *
	 * @param id
	 * @return driver details
	 */
	@RequestMapping(value = "driver/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<Driver> getDriverById(@PathVariable("id") int id) {
		Driver Driver = null;
		try {
			Driver = driverController.getDriverById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Driver>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Driver>(Driver, HttpStatus.OK);
	}

	/**
	 * Rest url to register a user/driver, method will store driver details on DB
	 *
	 * @param driver
	 * @return either Success or Failure
	 */
	@RequestMapping(value = "/register/driver", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<Driver> registerDriver(@Validated(NotNull.class) @RequestBody Driver driver) {
		try {
			driverController.registerDriver(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Driver>(driver, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Driver>(driver, HttpStatus.ACCEPTED);
	}

	/**
	 * rest url to send tracking records, and method will store those records into data base
	 *
	 * @param assetTrackingRecord
	 * @return either Success or Failure
	 */
	@RequestMapping(value = "/store/asset/trackingrecord", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<AssetTrackingRecord> storeTrackingRecord(
			@Validated(NotNull.class) @RequestBody AssetTrackingRecord assetTrackingRecord) {
		try {
			assetTrackingRdcontroller.storeTrackingRecord(assetTrackingRecord);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<AssetTrackingRecord>(assetTrackingRecord, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AssetTrackingRecord>(assetTrackingRecord, HttpStatus.ACCEPTED);
	}

	/**
	 * rest url to filter tracking records on the basis of deviceId, assetType, driverId, startTime, endTime, in these deviceId and assetType
	 * is required fields
	 *
	 * @param deviceId
	 * @param assetType
	 * @param driverId
	 * @param startTime long milliseconds
	 * @param endTime   long milliseconds
	 * @return collection of tracking records which meet filter criteria
	 */
	@RequestMapping(value = "/trackingrecord", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }) public @ResponseBody ResponseEntity<List<AssetTrackingRecord>> getAssetTrackingRecords(
			@RequestParam(value = "deviceId", required = true) String deviceId, @RequestParam(value = "assetType", required = true) String assetType,
			@RequestParam("DriverId") int driverId, @RequestParam("startDate") long startTime, @RequestParam("endDate") long endTime) {
		List<AssetTrackingRecord> trackingRecords = null;
		try {
			trackingRecords = assetTrackingRdcontroller.getAssetTrackingRecordBy(deviceId, driverId, assetType, startTime, endTime);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<AssetTrackingRecord>>(trackingRecords, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<AssetTrackingRecord>>(trackingRecords, HttpStatus.ACCEPTED);
	}
}