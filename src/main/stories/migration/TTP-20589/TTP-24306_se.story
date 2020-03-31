!-- ----------------
!-- TTP-17892 - (MBMD) - ACC6 - MyAccount - Change Password
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens sweden
Given is 'D2C' website for brand 'Siemens' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17892 - (MBMD) - ACC6 - MyAccount - Change Password
Scenario: TTP-24306 - (MBMD) - ACC6 - MyAccount - Change Password
GivenStories: migration/TTP-20589/steps/TTP-24306.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
