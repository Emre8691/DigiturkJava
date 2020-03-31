!-- ----------------
!-- TTP-100249 - Bosch - (MBMD) - Staff - MyAccount - Password Forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'STAFF' website for brand 'Bosch' and country 'germany' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100249 - (MBMD) - Staff - MyAccount - Password Forgotten
Scenario: TTP-100249 - Bosch - (MBMD) - MyAccount - Password Forgotten
GivenStories: migration/TTP-20589/steps/TTP-100249.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
