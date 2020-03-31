!-- ----------------
!-- TTP-100175 -Bosch - (MBMD) - Staff - MyAccount - Change Password
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens france
Given is 'STAFF' website for brand 'Bosch' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100175 - (MBMD) - ACC6 - MyAccount - Change Password
Scenario: TTP-100175 - (MBMD) - ACC6 - MyAccount - Change Password
GivenStories: migration/TTP-20589/steps/TTP-100175.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
