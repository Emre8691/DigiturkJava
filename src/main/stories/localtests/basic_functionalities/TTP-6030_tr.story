!-- ----------------
!-- TTP-6030 - [Prod] - Add a Product to Basket - BOSCH-TR
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-6030 - [Prod] - Add a Product to Basket - BOSCH-TR
Scenario: TTP-6030 - [Prod] - Add a Product to Basket - BOSCH-TR
GivenStories: localtests/basic_functionalities/steps/TTP-6030.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
