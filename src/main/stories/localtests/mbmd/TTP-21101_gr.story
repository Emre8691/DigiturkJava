!-- ----------------
!-- TTP-21101 - Neff/Balay - (MBMD) - PDP2 - Breadcrumbs Shop
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay greece
Given is 'D2C' website for brand 'Balay' and country 'greece'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21101 - Neff/Balay - (MBMD) - PDP2 - Breadcrumbs Shop
Scenario: TTP-21101 - Neff/Balay - (MBMD) - PDP2 - Breadcrumbs Shop
GivenStories: localtests/mbmd/steps/TTP-21101.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
