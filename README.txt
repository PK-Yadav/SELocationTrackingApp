**Tracking Services**

A set of APIs to track vehicles, mobiles or any orher kind of gps enabled device. 
There is a certain pre-requisites that are required in order to track.

* The person driving the vehicle has to be registered.
* The vehicle whose tracking has to be done needs to be registered.

Tracking will only be done in case the user and vehicle are on a trip.

There are different controllers for different kind of services:

User/Driver-APIs - apis related to user registration and retrieval.
APIS: 
* localhost:8080/api/driver/{id} GET  Path param: driverId,  Return:- Driver details by id
* localhost:8080/api/register/driver POST Request param: Driver Json
 /**
{
	"firstName":"Amit",
	"lastName": "Kumar",
	"mobileNumber":9898989890,
	"licenceNumber":"JH02-12351-12",
	"entryDt": 1515564246730 // optional if we dont send it's value, current system date gets picked
}
 Body Json to register a driver/user
**/

** TrackingRecord-APIs:- apis related to store/add tracking records and fetch tracking records
* localhost:8080/api//store/asset/trackingrecord POST Request param: AssetTrackingRecord json

 /**
{
	"deviceId":"121",
	"driverId":1,
	"currentLatitude":89.956,
	"currentLongitude":10.8990,
	"assetType":"VEH",
	"speed":90.8,
	"timeStamp":1515564246799,
	"additionalInfo":"{\"place\":\"uppal\"}"
}

Body Json to store tracking records in DB.
**/

** http://localhost:8080/api/trackingrecord GET QueryParams : deviceId, driverId, assetType( like -- MOB or VEH), startDate, endDate
 for example :-

 http://localhost:8080/api/trackingrecord?deviceId=121&DriverId=1&assetType=VEH&startDate=1515436200000&endDate=1515564247999

 this will filter tracking records between the given time period on the basis of deviceId, driverId and assetTypes


 *************** Table schemas **************


CREATE TABLE IF NOT EXISTS `vehicle` (
 `vehicle_id` INT NOT NULL AUTO_INCREMENT ,
 `vehicle_number` VARCHAR(45) NOT NULL ,
 `reg_year` VARCHAR(4) NOT NULL ,
 `gps_device_id` varchar(25) NOT NULL,
 `start_date` DATETIME,
 PRIMARY KEY (`vehicle_id`) );


 CREATE TABLE IF NOT EXISTS `driver` (
 `driver_id` INT NOT NULL AUTO_INCREMENT ,
 `name` VARCHAR(45) NOT NULL ,
 `address` VARCHAR(45) NULL ,
 `licence_number` VARCHAR(45) NULL ,
 `mobile_number` varchar(10) NOT NULL,
 `entry_dt` DATETIME,
 PRIMARY KEY (`driver_id`) );


CREATE TABLE `asset_tracking_record`
(
    `tracking_id` int auto_increment PRIMARY KEY,
    `asset_type` VARCHAR(50) NOT NULL,
    `vehicle_speed` double NOT NULL,
    `latitude` double NOT NULL,
    `longitude` double NOT NULL,
    `track_time` DATETIME NOT NULL DEFAULT NOW(),
    `driver_id` int NOT NULL,
    `vehicle_id` int NOT NULL,
    `additional_info` JSON,
    CONSTRAINT `fk_trackRd_has_driver_driver1`
    FOREIGN KEY (`driver_id` )
    REFERENCES `driver` (`driver_id` ),
    CONSTRAINT `fk_trackRd_has_vehicle_vehicle1`
    FOREIGN KEY (`vehicle_id` )
    REFERENCES `vehicle` (`vehicle_id`)
);


