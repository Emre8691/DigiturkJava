!-- ----------------
!-- TTP-913 -  Returning from the DOB Appliance Overview Page 
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'french'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-913 -  Returning from the DOB Appliance Overview Page 
Scenario: TTP-913 -  Returning from the DOB Appliance Overview Page 
GivenStories: localtests/cs.dob/steps/TTP-913.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
