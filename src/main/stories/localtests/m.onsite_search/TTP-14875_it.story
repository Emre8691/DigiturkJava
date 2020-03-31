!-- ----------------
!-- TTP-14875 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V4
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS italy
Given is 'D2C' website for brand 'SIEMENS' and country 'italy'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14875 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V4
Scenario: TTP-14875 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V4
GivenStories: localtests/m.onsite_search/steps/TTP-14875.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
