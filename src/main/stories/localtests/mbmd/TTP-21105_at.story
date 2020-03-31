!-- ----------------
!-- TTP-21105 - Neff/Balay - (MBMD) - MYB2- MyBasket
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay austria
Given is 'D2C' website for brand 'Balay' and country 'austria'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21105 - Neff/Balay - (MBMD) - MYB2- MyBasket
Scenario: TTP-21105 - Neff/Balay - (MBMD) - MYB2- MyBasket
GivenStories: localtests/mbmd/steps/TTP-21105.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
