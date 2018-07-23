## Funda QA Assignment - Lucas Germani

### Tech Stack

- Selenium
- Gauge
- JUnit
- Maven
- Gauge Maven Plugin

### Design Patterns Used
- **Page Factory**: Design pattern main used to avoid code duplication, specially locators, using @FindBy anotation is possible to locate and interact with webelements without the need of keeping the locator explicit on the code. This is possible through internal PageFactory logic.
- **PageObjectModel (POM)**: Complementary patern to PageFactory, POM means that each page and it own locators and behaviours should be represented in a single object (based on SRP principle) in order to improve reusability and manutenaility.
- **Test specification in plain text**: Test cenarios and specifications are written in plain text in gauge *.spec files, has similar benefits to BDD (ex: Cucumber), but without the need to use keywords like Given, When, Then. This helps to show and discuss test scenarios with business persons (ex: Product Owners and Business Analysts).

### Test Scenarios
Test scenarios are described also in /specs folder inside this project.
The test scenarios are executable through gauge runner or gauge maven plugin.

Example:

````
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

````


### Notes
Due to limited  time, not all scenarios are completly covered.
It was not possible to execute properly the tests, at funda's page there is some kind of automation prevention, whenever an automated browser is open at the page a reCAPTCHA is promped (https://imgur.com/a/Ai1j2v7), considering that the scenarios might not run perfectly, some adjustments in runtime are needed (configure correctly element waits) but for porpose of coding skills evaluation it should be enough.
