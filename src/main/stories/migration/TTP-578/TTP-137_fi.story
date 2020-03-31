!-- ----------------
!-- TTP-137 - Automatic: MyBasket: My Basket (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS finland
Given is 'D2C' website for brand 'SIEMENS' and country 'finland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-137 - Automatic: MyBasket: My Basket (Siemens)
Scenario: TTP-137 - Automatic: MyBasket: My Basket (Siemens)
GivenStories: migration/TTP-578/steps/TTP-137.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
