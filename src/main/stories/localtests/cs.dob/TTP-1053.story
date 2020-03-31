!-- ----------------
!-- TTP-1053 - Enter DOB with a registered appliance form
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'french'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1053 - Enter DOB with a registered appliance form
Scenario: TTP-1053 - Enter DOB with a registered appliance form
GivenStories: localtests/cs.dob/steps/TTP-1053.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
