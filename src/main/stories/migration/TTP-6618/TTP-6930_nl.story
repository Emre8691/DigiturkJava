!-- ----------------
!-- TTP-6930 - [Prod] - HOME Page and SHOP availability - BOSCH-TR
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch netherlands
Given is 'D2C' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-6930 - [Prod] - HOME Page and SHOP availability - BOSCH-TR
Scenario: TTP-6930 - [Prod] - HOME Page and SHOP availability - BOSCH-TR
GivenStories: migration/TTP-6618/steps/TTP-6930.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
