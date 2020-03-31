!-- ----------------
!-- TTP-23889 - Siemens - many items - A&B products -scenario2
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'STAFF' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23889 - Siemens - many items - A&B products -scenario2
Scenario: TTP-23889 - Siemens - many items - A&B products -scenario2
GivenStories: migration/TTP-24026/steps/TTP-23889.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
