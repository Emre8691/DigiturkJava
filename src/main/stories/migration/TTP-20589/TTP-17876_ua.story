!-- ----------------
!-- TTP-17876 - (MBMD) - BAS4 - Product Filter SHOP
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch ukraine
Given is 'D2C' website for brand 'Bosch' and country 'ukraine'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17876 - (MBMD) - BAS4 - Product Filter SHOP
Scenario: TTP-17876 - (MBMD) - BAS4 - Product Filter SHOP
GivenStories: migration/TTP-20589/steps/TTP-17876.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
