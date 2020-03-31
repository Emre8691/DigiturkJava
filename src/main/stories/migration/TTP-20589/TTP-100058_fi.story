!-- ----------------
!-- TTP-100058 - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Siemens denmark
Given is 'D2C' website for brand 'Siemens' and country 'finland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100048 - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
Scenario: TTP-100058 - (MBMD) - ACC4 - MyAccount - Change Delivery Address Setings
GivenStories: migration/TTP-20589/steps/TTP-100058.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
