!-- ----------------
!-- TTP-17879 - (MBMD) - PDP2 - Breadcrumbs Shop
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch norway
Given is 'D2C' website for brand 'Bosch' and country 'norway'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-17879 - (MBMD) - PDP2 - Breadcrumbs Shop
Scenario: TTP-17879 - (MBMD) - PDP2 - Breadcrumbs Shop
GivenStories: localtests/mbmd/steps/TTP-17879.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
