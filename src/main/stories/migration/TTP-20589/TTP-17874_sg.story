!-- ----------------
!-- TTP-17874 - (MBMD) - BAS2 - Category Flyout
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch singapore
Given is 'D2C' website for brand 'Bosch' and country 'singapore'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17874 - (MBMD) - BAS2 - Category Flyout
Scenario: TTP-17874 - (MBMD) - BAS2 - Category Flyout
GivenStories: migration/TTP-20589/steps/TTP-17874.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
