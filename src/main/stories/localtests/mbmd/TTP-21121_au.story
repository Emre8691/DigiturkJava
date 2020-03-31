!-- ----------------
!-- TTP-21121 - Neff/Balay - (MBMD) - PDP1- Product Images - Product Detail
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff australia
Given is 'D2C' website for brand 'Neff' and country 'australia'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21121 - Neff/Balay - (MBMD) - PDP1- Product Images - Product Detail
Scenario: TTP-21121 - Neff/Balay - (MBMD) - PDP1- Product Images - Product Detail
GivenStories: localtests/mbmd/steps/TTP-21121.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
