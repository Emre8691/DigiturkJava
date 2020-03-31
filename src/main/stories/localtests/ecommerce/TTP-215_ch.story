!-- ----------------
!-- TTP-215 - Automatic: Checkout: Checkout Register a new user
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-215 - Automatic: Checkout: Checkout Register a new user
Scenario: TTP-215 - Automatic: Checkout: Checkout Register a new user
GivenStories: localtests/ecommerce/steps/TTP-215.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
