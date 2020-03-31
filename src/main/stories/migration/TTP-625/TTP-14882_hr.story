!-- ----------------
!-- TTP-14882 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V9
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS croatia
Given is 'D2C' website for brand 'SIEMENS' and country 'croatia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14882 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V9
Scenario: TTP-14882 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V9
GivenStories: migration/TTP-625/steps/TTP-14882.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
