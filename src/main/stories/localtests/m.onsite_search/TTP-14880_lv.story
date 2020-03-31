!-- ----------------
!-- TTP-14880 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V7
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS latvia
Given is 'D2C' website for brand 'SIEMENS' and country 'latvia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14880 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V7
Scenario: TTP-14880 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V7
GivenStories: localtests/m.onsite_search/steps/TTP-14880.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
