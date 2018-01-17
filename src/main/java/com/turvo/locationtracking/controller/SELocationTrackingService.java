package com.turvo.locationtracking.controller;

import com.turvo.locationtracking.dto.AssetTrackingRecordDTO;
import com.turvo.locationtracking.dto.DriverDTO;
import com.turvo.locationtracking.dto.VehicleDTO;
import com.turvo.locationtracking.entity.AssetTrackingRecord;
import com.turvo.locationtracking.entity.Driver;
import com.turvo.locationtracking.entity.Vehicle;
import com.turvo.locationtracking.serviceintf.IAssetTrackingRdService;
import com.turvo.locationtracking.serviceintf.IDriverService;
import com.turvo.locationtracking.serviceintf.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * This is rest webservice class which has exposed rest url for client to performed their operations related to this
 * tracking application.
 *
 * @author pappuy
 * @version 1.0
 */
@RestController @RequestMapping("/api") public class SELocationTrackingService {

	@Qualifier("driverService") @Autowired private IDriverService driverService;

	@Qualifier("assetTrackingRdService") @Autowired private IAssetTrackingRdService assetTrackingRdService;

	@Qualifier("vehicleService")
	@Autowired
	private IVehicleService vehicleService;
	/**
	 * Rest url to get driver by id
	 *
	 * @param id
	 * @return driver details
	 */
	@RequestMapping(value = "driver/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<Driver> getDriverById(@PathVariable("id") int id) {
		Driver driver = null;
		try {
			driver = driverService.getDriverById(id);
			if (null == driver) {
				return new ResponseEntity<Driver>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Driver>(driver, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Driver>(driver, HttpStatus.OK);
	}

	/**
	 * Rest url to register a user/driver, method will store driver details on DB
	 *
	 * @param driverDTO
	 * @return either Success or Failure
	 */
	@RequestMapping(value = "/register/driver", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<Driver> registerDriver(@RequestBody DriverDTO driverDTO) {
		Driver driver = null;
		try {
			driver = driverService.registerDriver(driverDTO);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Driver>(driver, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Driver>(driver, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/register/vehicle", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Vehicle> registerVehicle(@RequestBody VehicleDTO vehicleDTO){

		Vehicle vehicle = null;
		try {
			vehicle = vehicleService.registerVehicle(vehicleDTO);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Vehicle>(vehicle, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.ACCEPTED);
	}

	/**
	 * rest url to send tracking records, and method will store those records into data base
	 *
	 * @param assetTrackingRecordDTO
	 * @return either Success or Failure with saved record
	 */
	@RequestMapping(value = "/asset/trackingrecord/{assetType}", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<AssetTrackingRecord> storeTrackingRecord(
			@RequestBody AssetTrackingRecordDTO assetTrackingRecordDTO, @PathVariable("assetType") String assetType) {
		AssetTrackingRecord assetTrackingRecord = null;
		try {
			assetTrackingRecordDTO.setAssetType(assetType);
			assetTrackingRecord = assetTrackingRdService.storeTrackingRecord(assetTrackingRecordDTO);
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
	 * @param vehicleId
	 * @param driverId
	 * @param startTime long milliseconds
	 * @param endTime   long milliseconds
	 * @return collection of tracking records which meet filter criteria
	 */
	@RequestMapping(value = "/trackingrecord", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE }) public @ResponseBody ResponseEntity<Set<AssetTrackingRecordDTO>> getAssetTrackingRecords(
			@RequestParam(value = "vehicleId", required = true) int vehicleId, @RequestParam("DriverId") int driverId,
			@RequestParam("startDate") long startTime, @RequestParam("endDate") long endTime) {
		Set<AssetTrackingRecordDTO> trackingRecords = null;
		try {
			trackingRecords = assetTrackingRdService.getAssetTrackingRecordBy(vehicleId, driverId, startTime, endTime);
			if (null == trackingRecords && trackingRecords.isEmpty()) {
				return new ResponseEntity<Set<AssetTrackingRecordDTO>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Set<AssetTrackingRecordDTO>>(trackingRecords, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Set<AssetTrackingRecordDTO>>(trackingRecords, HttpStatus.ACCEPTED);
	}


}