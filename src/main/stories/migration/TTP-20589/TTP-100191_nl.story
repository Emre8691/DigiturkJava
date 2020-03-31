!-- ----------------
!-- TTP-netherlands - (MBMD) - CHE5 - Checkout Guest
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch netherlands
Given is 'STAFF' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100178 - (MBMD) - CHE5 - Checkout Guest
Scenario: TTP-100191 - (MBMD) - CHE5 - Checkout Guest
GivenStories: migration/TTP-20589/steps/TTP-100191.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
