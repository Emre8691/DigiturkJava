!-- ----------------
!-- TTP-100278 - Bosch - (MBMD) - MyAccount - Change Delivery Address Setings
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch denmark
Given is 'STAFF' website for brand 'Bosch' and country 'denmark' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100278 - Bosch - (MBMD) - Staff - MyAccount - Change Delivery Address Setings
Scenario: TTP-100278 - Bosch - (MBMD) - MyAccount - Change MyProfile Personal Data
GivenStories: migration/TTP-20589/steps/TTP-100278.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
