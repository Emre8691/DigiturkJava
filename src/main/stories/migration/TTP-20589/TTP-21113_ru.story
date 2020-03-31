!-- ----------------
!-- TTP-21113 - Neff/Balay - (MBMD) - CHE1- Checkout Logged User
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay russia
Given is 'D2C' website for brand 'Balay' and country 'russia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21113 - Neff/Balay - (MBMD) - CHE1- Checkout Logged User
Scenario: TTP-21113 - Neff/Balay - (MBMD) - CHE1- Checkout Logged User
GivenStories: migration/TTP-20589/steps/TTP-21113.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
