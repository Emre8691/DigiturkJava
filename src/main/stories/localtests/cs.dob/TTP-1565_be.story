!-- ----------------
!-- TTP-1565 - e-numbers which are not DOB available
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1565 - e-numbers which are not DOB available
Scenario: TTP-1565 - e-numbers which are not DOB available
GivenStories: localtests/cs.dob/steps/TTP-1565.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
