package com.turvo.locationtracking.mapper;

import com.turvo.locationtracking.dto.AssetTrackingRecordDTO;
import com.turvo.locationtracking.entity.AssetTrackingRecord;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This is AssetTrackingRecordMapper class, to convert assetTrackingRecord entity to DTO and vice versa
 *
 * @author pappuy
 * @version 1.0
 */

public class AssetTrackingRecordMapper{

	/**
	 *
	 * @param assetTrackingRecord
	 * @return
	 */
	public static  AssetTrackingRecordDTO convertAssetTrackingRecordToAssetRdDTO(AssetTrackingRecord assetTrackingRecord){
		AssetTrackingRecordDTO assetTrackingRecordDTO= new AssetTrackingRecordDTO();
		assetTrackingRecordDTO.setTimeStamp(assetTrackingRecord.getTimeStamp());
		assetTrackingRecordDTO.setLongitude(assetTrackingRecord.getLongitude());
		assetTrackingRecordDTO.setLatitude(assetTrackingRecord.getLatitude());
		assetTrackingRecordDTO.setAdditionalInfo(assetTrackingRecord.getAdditionalInfo());
		assetTrackingRecordDTO.setAssetTrackingRdId(assetTrackingRecord.getAssetTrackingId());
		assetTrackingRecordDTO.setSpeed(assetTrackingRecord.getvSpeed());
		assetTrackingRecordDTO.setAssetType(assetTrackingRecord.getAssetType());
		assetTrackingRecordDTO.setDriverDTO(DriverMapper.convertDriverIntoDriverDTOForAssetRd(assetTrackingRecord.getDriver()));
		assetTrackingRecordDTO.setVehicleDTO(VehicleMapper.convertVehicleToVehicleDTOForAssetRd(assetTrackingRecord.getVehicle()));
		return assetTrackingRecordDTO;
	}

	/**
	 *
	 * @param assetTrackingRecords
	 * @return
	 */
	public static Set<AssetTrackingRecordDTO> convertAssetTrackingRecordsToAssetRdDTOsForDriver(Set<AssetTrackingRecord> assetTrackingRecords){
		Set<AssetTrackingRecordDTO> assetTrackingRecordDTOs = new HashSet<>();
		for(AssetTrackingRecord assetTrackingRecord : assetTrackingRecords){
			AssetTrackingRecordDTO assetTrackingRecordDTO = new AssetTrackingRecordDTO();
			assetTrackingRecordDTO.setTimeStamp(assetTrackingRecord.getTimeStamp());
			assetTrackingRecordDTO.setLongitude(assetTrackingRecord.getLongitude());
			assetTrackingRecordDTO.setLatitude(assetTrackingRecord.getLatitude());
			assetTrackingRecordDTO.setAdditionalInfo(assetTrackingRecord.getAdditionalInfo());
			assetTrackingRecordDTO.setAssetTrackingRdId(assetTrackingRecord.getAssetTrackingId());
			assetTrackingRecordDTO.setSpeed(assetTrackingRecord.getvSpeed());
			assetTrackingRecordDTO.setAssetType(assetTrackingRecord.getAssetType());
			assetTrackingRecordDTO.setVehicleDTO(VehicleMapper.convertVehicleToVehicleDTOForAssetRd(assetTrackingRecord.getVehicle()));
			assetTrackingRecordDTOs.add( assetTrackingRecordDTO);
		}
		return assetTrackingRecordDTOs;
	}

	/**
	 *
	 * @param assetTrackingRecordDTO
	 * @return
	 */
	public static AssetTrackingRecord convertAssetRdDTOToAssetTrackingRecord(AssetTrackingRecordDTO assetTrackingRecordDTO){
		AssetTrackingRecord assetTrackingRecord = new AssetTrackingRecord();
		assetTrackingRecord.setAssetType(assetTrackingRecordDTO.getAssetType());
		assetTrackingRecord.setAdditionalInfo(assetTrackingRecordDTO.getAdditionalInfo());
		assetTrackingRecord.setLatitude(assetTrackingRecordDTO.getLatitude());
		assetTrackingRecord.setLongitude(assetTrackingRecordDTO.getLongitude());
		assetTrackingRecord.setTimeStamp(new Date());
		assetTrackingRecord.setvSpeed(assetTrackingRecordDTO.getSpeed());
		return assetTrackingRecord;
	}

	/**
	 *
	 * @param assetTrackingRecords
	 * @return
	 */
	public static Set<AssetTrackingRecordDTO> convertAssetTrackingRecordsToAssetRdDTOsForVehicle(Set<AssetTrackingRecord> assetTrackingRecords){
		Set<AssetTrackingRecordDTO> assetTrackingRecordDTOs = new HashSet<>();
		for(AssetTrackingRecord assetTrackingRecord : assetTrackingRecords){
			AssetTrackingRecordDTO assetTrackingRecordDTO = new AssetTrackingRecordDTO();
			assetTrackingRecordDTO.setTimeStamp(assetTrackingRecord.getTimeStamp());
			assetTrackingRecordDTO.setLongitude(assetTrackingRecord.getLongitude());
			assetTrackingRecordDTO.setLatitude(assetTrackingRecord.getLatitude());
			assetTrackingRecordDTO.setAdditionalInfo(assetTrackingRecord.getAdditionalInfo());
			assetTrackingRecordDTO.setAssetTrackingRdId(assetTrackingRecord.getAssetTrackingId());
			assetTrackingRecordDTO.setSpeed(assetTrackingRecord.getvSpeed());
			assetTrackingRecordDTO.setAssetType(assetTrackingRecord.getAssetType());
			assetTrackingRecordDTO.setDriverDTO(DriverMapper.convertDriverIntoDriverDTOForAssetRd(assetTrackingRecord.getDriver()));
			assetTrackingRecordDTOs.add( assetTrackingRecordDTO);
		}
		return assetTrackingRecordDTOs;
	}

}