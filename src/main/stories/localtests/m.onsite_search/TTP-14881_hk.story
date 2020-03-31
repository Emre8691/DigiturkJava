!-- ----------------
!-- TTP-14881 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V8
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS hongkong
Given is 'D2C' website for brand 'SIEMENS' and country 'hongkong'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14881 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V8
Scenario: TTP-14881 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V8
GivenStories: localtests/m.onsite_search/steps/TTP-14881.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
