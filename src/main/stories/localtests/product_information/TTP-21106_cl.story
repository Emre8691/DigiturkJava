!-- ----------------
!-- TTP-21106 - Neff/Balay - (MBMD) - ACC1- Login
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay chile
Given is 'D2C' website for brand 'Balay' and country 'chile'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21106 - Neff/Balay - (MBMD) - ACC1- Login
Scenario: TTP-21106 - Neff/Balay - (MBMD) - ACC1- Login
GivenStories: localtests/product_information/steps/TTP-21106.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
