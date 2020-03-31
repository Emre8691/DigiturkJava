!-- ----------------
!-- TTP-17885 - (MBMD) - CHE5 - Checkout Guest
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch denmark
Given is 'D2C' website for brand 'Bosch' and country 'denmark'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17885 - (MBMD) - CHE5 - Checkout Guest
Scenario: TTP-17885 - (MBMD) - CHE5 - Checkout Guest
GivenStories: migration/TTP-20589/steps/TTP-17885.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
