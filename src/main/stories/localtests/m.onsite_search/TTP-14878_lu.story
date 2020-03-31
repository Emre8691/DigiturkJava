!-- ----------------
!-- TTP-14878 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V6
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS luxembourg
Given is 'D2C' website for brand 'SIEMENS' and country 'luxembourg'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14878 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V6
Scenario: TTP-14878 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V6
GivenStories: localtests/m.onsite_search/steps/TTP-14878.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
