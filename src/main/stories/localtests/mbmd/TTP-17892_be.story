!-- ----------------
!-- TTP-17892 - (MBMD) - ACC6 - MyAccount - Change Password
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch belgium
Given is 'D2C' website for brand 'Bosch' and country 'belgium' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17892 - (MBMD) - ACC6 - MyAccount - Change Password
Scenario: TTP-17892 - (MBMD) - ACC6 - MyAccount - Change Password
GivenStories: localtests/mbmd/steps/TTP-17892.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
