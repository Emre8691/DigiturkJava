!-- ----------------
!-- TTP-2465 - [Prod] - Check Adobe Analytics data - 1 option countries - Accept Cookie
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for  belgium
Given is 'D2C' website for brand '' and country 'belgium'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-2465 - [Prod] - Check Adobe Analytics data - 1 option countries - Accept Cookie
Scenario: TTP-2465 - [Prod] - Check Adobe Analytics data - 1 option countries - Accept Cookie
GivenStories: localtests/basic_functionalities/steps/TTP-2465.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
