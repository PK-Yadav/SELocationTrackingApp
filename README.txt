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
* localhost:8080/api//register/driver POST Request param: Driver Json
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


CREATE TABLE Driver (
    driver_id int  auto_increment,
    last_name varchar(255) NOT NULL,
    first_name varchar(255),
    licence_number varchar(25) NOT NULL unique,
    mobile_number varchar(11) NOT NULL,
    entry_dt DATETIME  NOT NULL default NOW(),
    PRIMARY KEY (driver_id)
);

CREATE TABLE ASSETTRACKINGRECORD
(
    asset_tracking_id int auto_increment PRIMARY KEY,
    device_id varchar(20) NOT NULL,
    asset_type VARCHAR(5) NOT NULL,
    speed double,
    current_latitude double NOT NULL,
    current_longitude double NOT NULL,
    stored_time DATETIME NOT NULL DEFAULT NOW(),
    driver_id int NOT NULL,
    additional_info JSON
);



