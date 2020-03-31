!-- ----------------
!-- TTP-100227 -Bosch - (MBMD) - Staff - MyAccount - Change Delivery Address Setings
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch Turkey
Given is 'STAFF' website for brand 'Bosch' and country 'turkey' 
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided




!-- ----------------
!-- TTP-100227 - (MBMD) - Staff - MyAccount - Change Delivery Address Setings
Scenario: TTP-100227 - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
GivenStories: migration/TTP-20589/steps/TTP-100227.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
