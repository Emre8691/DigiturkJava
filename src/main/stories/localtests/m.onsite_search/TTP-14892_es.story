!-- ----------------
!-- TTP-14892 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V19
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS spain
Given is 'D2C' website for brand 'SIEMENS' and country 'spain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14892 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V19
Scenario: TTP-14892 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V19
GivenStories: localtests/m.onsite_search/steps/TTP-14892.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
