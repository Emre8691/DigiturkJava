!-- ----------------
!-- TTP-11844 - PI - Marketing List Page - Prefiltered List
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS spain
Given is 'D2C' website for brand 'SIEMENS' and country 'spain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11844 - PI - Marketing List Page - Prefiltered List
Scenario: TTP-11844 - PI - Marketing List Page - Prefiltered List
GivenStories: migration/TTP-649/steps/TTP-11844.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
