!-- ----------------
!-- TTP-406 - Automatic: CEW: Complete Process
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-406 - Automatic: CEW: Complete Process
Scenario: TTP-406 - Automatic: CEW: Complete Process
GivenStories: migration/TTP-589/steps/TTP-406.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
