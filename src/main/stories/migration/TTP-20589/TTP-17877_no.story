!-- ----------------
!-- TTP-17877 - (MBMD) - BAS5 - Product Filter
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch norway
Given is 'D2C' website for brand 'Bosch' and country 'norway'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17877 - (MBMD) - BAS5 - Product Filter
Scenario: TTP-17877 - (MBMD) - BAS5 - Product Filter
GivenStories: migration/TTP-20589/steps/TTP-17877.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
