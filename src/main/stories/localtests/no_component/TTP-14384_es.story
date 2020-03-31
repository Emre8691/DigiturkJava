!-- ----------------
!-- TTP-14384 - (BALAY) - AddToBasket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay spain
Given is 'D2C' website for brand 'Balay' and country 'spain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-14384 - (BALAY) - AddToBasket
Scenario: TTP-14384 - (BALAY) - AddToBasket
GivenStories: localtests/no_component/steps/TTP-14384.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
