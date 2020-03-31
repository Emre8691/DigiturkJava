!-- ----------------
!-- TTP-21099 - Neff/Balay - (MBMD) - Flyout Navigation
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay portugal
Given is 'D2C' website for brand 'Balay' and country 'portugal'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21099 - Neff/Balay - (MBMD) - Flyout Navigation
Scenario: TTP-21099 - Neff/Balay - (MBMD) - Flyout Navigation
GivenStories: localtests/mbmd/steps/TTP-21099.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
