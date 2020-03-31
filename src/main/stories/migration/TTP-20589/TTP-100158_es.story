!-- ----------------
!-- TTP-100158 -Bosch - (MBMD) - Staff - MyAccount - Change Delivery Address Setings
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens Sweden
Given is 'STAFF' website for brand 'Bosch' and country 'spain'

Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided




!-- ----------------
!-- TTP-100158 - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
Scenario: TTP-100158 - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
GivenStories: migration/TTP-20589/steps/TTP-100158.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
