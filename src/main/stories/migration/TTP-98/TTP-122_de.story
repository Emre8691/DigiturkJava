!-- ----------------
!-- TTP-122 - Automatic:Logout (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-122 - Automatic:Logout (Siemens)
Scenario: TTP-122 - Automatic:Logout (Siemens)
GivenStories: migration/TTP-98/steps/TTP-122.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
