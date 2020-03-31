!-- ----------------
!-- TTP-11830 - PI - Marketing Product Detail Page - Award Teaser
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11830 - PI - Marketing Product Detail Page - Award Teaser
Scenario: TTP-11830 - PI - Marketing Product Detail Page - Award Teaser
GivenStories: localtests/product_information/steps/TTP-11830.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
