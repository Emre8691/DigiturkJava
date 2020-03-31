!-- ----------------
!-- TTP-21108 - Neff/Balay - (MBMD) - CHE5 - Checkout Guest
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay germany
Given is 'D2C' website for brand 'Balay' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21108 - Neff/Balay - (MBMD) - CHE5 - Checkout Guest
Scenario: TTP-21108 - Neff/Balay - (MBMD) - CHE5 - Checkout Guest
GivenStories: migration/TTP-20589/steps/TTP-21108.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
