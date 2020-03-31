!-- ----------------
!-- TTP-23899 - Siemens - plant
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'D2C' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23899 - Siemens - plant
Scenario: TTP-23899 - Siemens - plant
GivenStories: localtests/sap/steps/TTP-23899.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
