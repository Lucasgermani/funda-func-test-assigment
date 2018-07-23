Huur Search Test
=====================
Created by Lucasgermani on 23/07/2018

This is an executable specification file which follows markdown syntax.
This specification should test the search mechanism through the Huur option

* Given I am at funda homepage


Full Search
----------------
* Search in "HUUR" for location  = "Eindhoven" and minimum price of "100" and maximum price of "1000" and in a range of "ONE_KM"
* Validate Search URL based on search criteria

Just Location
----------------
* Search in "HUUR" for location = "Amsterdam"
* Validate Search URL based on search criteria

Location and minimum value
----------------
* Search in "HUUR" for location  = "Utrecht" and minimum price of "100"
* Validate Search URL based on search criteria

Location and minimum value
----------------
* Search in "HUUR" for location  = "Gemeente Utrecht" and maximum price of "1200"
* Validate Search URL based on search criteria

Location, minimum and maximum value
----------------
* Search in "HUUR" for location  = "Gemeente Eindhoven" and minimum price of "100" and maximum price of "1000"
* Validate Search URL based on search criteria

Location and range
----------------
* Search in "HUUR" for location  = "Gemeente Amsterdam" and range of "TEN_KM"
* Validate Search URL based on search criteria