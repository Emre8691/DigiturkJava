!-- ----------------
!-- TTP-100220 -Bosch - (MBMD) - Staff - MyAccount - Change Password
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch Belgium
Given is 'STAFF' website for brand 'Bosch' and country 'belgium' and language 'Dutch' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100220 - (MBMD) - Staff - MyAccount - Change Password
Scenario: TTP-100220 - (MBMD) - ACC6 - MyAccount - Change Password
GivenStories: migration/TTP-20589/steps/TTP-100220.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
