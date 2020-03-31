!-- ----------------
!-- TTP-100161 -Bosch - (MBMD) - Staff - MyAccount - Change Password
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch norway
Given is 'STAFF' website for brand 'Bosch' and country 'spain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100161 - (MBMD) - ACC6 - MyAccount - Change Password

Scenario: TTP-100161 - (MBMD) - ACC6 - MyAccount - Change Password
GivenStories: migration/TTP-20589/steps/TTP-100161.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
