!-- ----------------
!-- TTP-11843 - PI - Marketing Product Detail Page - Online Dealers
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11843 - PI - Marketing Product Detail Page - Online Dealers
Scenario: TTP-11843 - PI - Marketing Product Detail Page - Online Dealers
GivenStories: migration/TTP-649/steps/TTP-11843.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
