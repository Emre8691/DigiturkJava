!-- ----------------
!-- TTP-14870 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V1
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS norway
Given is 'D2C' website for brand 'SIEMENS' and country 'norway'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14870 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V1
Scenario: TTP-14870 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V1
GivenStories: localtests/m.onsite_search/steps/TTP-14870.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
