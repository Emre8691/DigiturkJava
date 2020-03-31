!-- ----------------
!-- TTP-1051 - Access from myAccount to DOB 
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for  belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-1051 - Access from myAccount to DOB 
Scenario: TTP-1051 - Access from myAccount to DOB 
GivenStories: localtests/cs.dob/steps/TTP-1051.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
