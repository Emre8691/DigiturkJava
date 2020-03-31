!-- ----------------
!-- TTP-100268 - Bosch - (MBMD) - MyAccount - Change Delivery Address Setings
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch finland
Given is 'STAFF' website for brand 'Bosch' and country 'finland' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided



!-- ----------------
!-- TTP-100268 - Bosch - (MBMD) - Staff - MyAccount - Change Delivery Address Setings
Scenario: TTP-100268 - Bosch - (MBMD) - MyAccount - Change MyProfile Personal Data
GivenStories: migration/TTP-20589/steps/TTP-100268.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
