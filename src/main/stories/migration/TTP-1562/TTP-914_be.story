!-- ----------------
!-- TTP-914 -  Change the Problem on DOB Appointment Page 
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-914 -  Change the Problem on DOB Appointment Page 
Scenario: TTP-914 -  Change the Problem on DOB Appointment Page 
GivenStories: migration/TTP-1562/steps/TTP-914.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
