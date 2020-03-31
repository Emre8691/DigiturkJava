!-- ----------------
!-- TTP-100248 - (MBMD) - ACC3 - MyAccount - Change MyProfile Personal Data
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'STAFF' website for brand 'Bosch' and country 'germany' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100248 - (MBMD) - Staff - MyAccount - Change MyProfile Personal Data
Scenario: TTP-100248 - Bosch - (MBMD) - MyAccount - Change MyProfile Personal Data
GivenStories: migration/TTP-20589/steps/TTP-100248.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
