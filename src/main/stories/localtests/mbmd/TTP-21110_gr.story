!-- ----------------
!-- TTP-21110 - Neff/Balay - (MBMD) - BAS4 - Product Filter SHOP
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay greece
Given is 'D2C' website for brand 'Balay' and country 'greece'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21110 - Neff/Balay - (MBMD) - BAS4 - Product Filter SHOP
Scenario: TTP-21110 - Neff/Balay - (MBMD) - BAS4 - Product Filter SHOP
GivenStories: localtests/mbmd/steps/TTP-21110.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
