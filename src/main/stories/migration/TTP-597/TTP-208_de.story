!-- ----------------
!-- TTP-208 - Automatic:Customer Service: Newsletter
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-208 - Automatic:Customer Service: Newsletter
Scenario: TTP-208 - Automatic:Customer Service: Newsletter
GivenStories: migration/TTP-597/steps/TTP-208.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
