!-- ----------------
!-- TTP-100267 -Bosch - (MBMD) - Staff - MyAccount - Change MyProfile Personal Data
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch finland
Given is 'STAFF' website for brand 'Bosch' and country 'finland' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100267 - Bosch - (MBMD) - Staff - MyAccount - Change MyProfile Personal Data 
Scenario: TTP-100267 - Bosch - (MBMD) - MyAccount - Change Delivery Address Setings
GivenStories: migration/TTP-20589/steps/TTP-100267.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
