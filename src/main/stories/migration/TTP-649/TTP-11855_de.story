!-- ----------------
!-- TTP-11855 - PI - Marketing List Page - Sales Program
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11855 - PI - Marketing List Page - Sales Program
Scenario: TTP-11855 - PI - Marketing List Page - Sales Program
GivenStories: migration/TTP-649/steps/TTP-11855.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
