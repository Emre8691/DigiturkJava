!-- ----------------
!-- TTP-23897 - Siemens - public
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for  turkey
Given is 'D2C' website for brand '' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23897 - Siemens - public
Scenario: TTP-23897 - Siemens - public
GivenStories: localtests/sap/steps/TTP-23897.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
