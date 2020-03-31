!-- ----------------
!-- TTP-14888 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V15
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS thailand
Given is 'D2C' website for brand 'SIEMENS' and country 'thailand'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14888 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V15
Scenario: TTP-14888 - (DS) Customer Service ND - Customer Service - Flyout SER1 -V15
GivenStories: migration/TTP-625/steps/TTP-14888.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
