!-- ----------------
!-- TTP-21103 - Neff/Balay - (MBMD) - BAS5 - Product Filter
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff portugal
Given is 'D2C' website for brand 'Neff' and country 'portugal'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21103 - Neff/Balay - (MBMD) - BAS5 - Product Filter
Scenario: TTP-21103 - Neff/Balay - (MBMD) - BAS5 - Product Filter
GivenStories: localtests/mbmd/steps/TTP-21103.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
