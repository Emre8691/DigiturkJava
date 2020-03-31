!-- ----------------
!-- TTP-21119 - Neff/Balay - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay greece
Given is 'D2C' website for brand 'Balay' and country 'greece'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21119 - Neff/Balay - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
Scenario: TTP-21119 - Neff/Balay - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
GivenStories: localtests/mbmd/steps/TTP-21119.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
