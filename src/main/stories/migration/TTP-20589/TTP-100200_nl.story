!-- ----------------
!-- TTP-100188 -Bosch - (MBMD) - Staff - MyAccount - Change Password
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens france
Given is 'OUTLET' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100201 - (MBMD) - ACC6 - MyAccount - Change Password
Scenario: TTP-100200 - (MBMD) - ACC6 - MyAccount - Change Password
GivenStories: migration/TTP-20589/steps/TTP-100200.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
