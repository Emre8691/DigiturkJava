!-- ----------------
!-- TTP-8021 - [Prod] - Add one item from all category - Delete 10 item from Basket - Member Login - Any Credit Card Payment - BOSCH-TR
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for  turkey
Given is 'D2C' website for brand '' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-8021 - [Prod] - Add one item from all category - Delete 10 item from Basket - Member Login - Any Credit Card Payment - BOSCH-TR
Scenario: TTP-8021 - [Prod] - Add one item from all category - Delete 10 item from Basket - Member Login - Any Credit Card Payment - BOSCH-TR
GivenStories: localtests/basic_functionalities/steps/TTP-8021.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
