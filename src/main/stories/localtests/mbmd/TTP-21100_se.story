!-- ----------------
!-- TTP-21100 - Neff/Balay - (MBMD) - BAS2 - Category Flyout
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay sweden
Given is 'D2C' website for brand 'Balay' and country 'sweden'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21100 - Neff/Balay - (MBMD) - BAS2 - Category Flyout
Scenario: TTP-21100 - Neff/Balay - (MBMD) - BAS2 - Category Flyout
GivenStories: localtests/mbmd/steps/TTP-21100.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
