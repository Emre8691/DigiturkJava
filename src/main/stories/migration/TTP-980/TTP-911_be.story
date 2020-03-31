!-- ----------------
!-- TTP-911 - E-/FD-number Error Message
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'Siemens' and country 'belgium' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-911 - E-/FD-number Error Message
Scenario: TTP-911 - E-/FD-number Error Message
GivenStories: migration/TTP-980/steps/TTP-911.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
