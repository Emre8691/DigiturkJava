!-- ----------------
!-- TTP-11848 - PI - Marketing List Page - Energy Class
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greatbritain
Given is 'STAFF' website for brand 'SIEMENS' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11848 - PI - Marketing List Page - Energy Class
Scenario: TTP-11848 - PI - Marketing List Page - Energy Class
GivenStories: migration/TTP-649/steps/TTP-11848.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
