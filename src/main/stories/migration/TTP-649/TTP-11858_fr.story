!-- ----------------
!-- TTP-11858 - PI - Marketing List Page - Sales and Presales information
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'D2C' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11858 - PI - Marketing List Page - Sales and Presales information
Scenario: TTP-11858 - PI - Marketing List Page - Sales and Presales information
GivenStories: migration/TTP-649/steps/TTP-11858.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
