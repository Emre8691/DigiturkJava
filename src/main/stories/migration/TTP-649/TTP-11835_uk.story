!-- ----------------
!-- TTP-11835 - PI - Marketing Product Detail Page - Consumer Oriented Product Information COPI
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greatbritain
Given is 'D2C' website for brand 'SIEMENS' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11835 - PI - Marketing Product Detail Page - Consumer Oriented Product Information COPI
Scenario: TTP-11835 - PI - Marketing Product Detail Page - Consumer Oriented Product Information COPI
GivenStories: migration/TTP-649/steps/TTP-11835.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
