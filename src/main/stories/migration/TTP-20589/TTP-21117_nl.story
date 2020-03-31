!-- ----------------
!-- TTP-21117 - Neff/Balay - (MBMD) - CHE4- Checkout Register a New User
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay netherlands
Given is 'D2C' website for brand 'Balay' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21117 - Neff/Balay - (MBMD) - CHE4- Checkout Register a New User
Scenario: TTP-21117 - Neff/Balay - (MBMD) - CHE4- Checkout Register a New User
GivenStories: migration/TTP-20589/steps/TTP-21117.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
