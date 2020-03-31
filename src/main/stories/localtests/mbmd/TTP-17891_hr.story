!-- ----------------
!-- TTP-17891 - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch croatia
Given is 'D2C' website for brand 'Bosch' and country 'croatia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17891 - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
Scenario: TTP-17891 - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
GivenStories: localtests/mbmd/steps/TTP-17891.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
