!-- ----------------
!-- TTP-100111 - (MBMD) - ACC6 - MyAccount - Change Password
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens norway
Given is 'D2C' website for brand 'Siemens' and country 'southafrica'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100111 - (MBMD) - ACC6 - MyAccount - Change Password
Scenario: TTP-100111 - (MBMD) - ACC6 - MyAccount - Change Password
GivenStories: migration/TTP-20589/steps/TTP-100111.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
