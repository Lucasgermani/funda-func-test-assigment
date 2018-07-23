Koop Search Test
=====================
Created by Lucasgermani on 23/07/2018

This is an executable specification file which follows markdown syntax.
This specification should test the search mechanism through the koop option

* Given I am at funda homepage

Full Search
----------------
* Search in "KOOP" for location  = "Gemeente Eindhoven" and minimum price of "50000" and maximum price of "150000" and in a range of "ONE_KM"
* Validate Search URL based on search criteria

Just Location
----------------
* Search in "KOOP" for location = "Gemeente Amsterdam"
* Validate Search URL based on search criteria

Location and minimum value
----------------
* Search in "KOOP" for location  = "Gemeente Utrecht" and minimum price of "50000"
* Validate Search URL based on search criteria

Location and maximum value
----------------
* Search in "KOOP" for location  = "Gemeente Utrecht" and maximum price of "150000"
* Validate Search URL based on search criteria

Location, minimum and maximum value
----------------
* Search in "KOOP" for location  = "Gemeente Eindhoven" and minimum price of "50000" and maximum price of "150000"
* Validate Search URL based on search criteria

Location and range
----------------
* Search in "KOOP" for location  = "Gemeente Amsterdam" and range of "ONE_KM"
* Validate Search URL based on search criteria

