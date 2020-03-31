!-- ----------------
!-- TTP-100185 - Bosch - (MBMD)- Staff - Change Delivery Settings Address
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch Netherlands
Given is 'STAFF' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TEST-100185 - (MBMD) - BAS3 - Change Delivery Settings Address
Scenario: TEST-100185 - (MBMD) - BAS3 - Change Delivery Settings Address
GivenStories: migration/TTP-20589/steps/TTP-100185.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
