!-- ----------------
!-- TTP-1296 - Product categories which are not DOB available
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'french'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1296 - Product categories which are not DOB available
Scenario: TTP-1296 - Product categories which are not DOB available
GivenStories: localtests/cs.dob/steps/TTP-1296.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
