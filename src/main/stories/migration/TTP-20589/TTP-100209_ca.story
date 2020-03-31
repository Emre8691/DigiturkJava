!-- ----------------
!-- TTP-100209 - Bosch - (MBMD) - Staff - MyAccount - Password Forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch canada
Given is 'STAFF' website for brand 'Bosch' and country 'canada' and language 'French' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100209 - (MBMD) - ACC7 - MyAccount - Password Forgotten
Scenario: TTP-100209 - (MBMD) - ACC7 - MyAccount - Password Forgotten
GivenStories: migration/TTP-20589/steps/TTP-100209.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
