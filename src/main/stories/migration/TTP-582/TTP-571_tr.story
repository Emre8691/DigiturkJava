!-- ----------------
!-- TTP-571 - Automatic: Spare parts search result steps
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS turkey
Given is 'STAFF' website for brand 'SIEMENS' and country 'turkey'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-571 - Automatic: Spare parts search result steps
Scenario: TTP-571 - Automatic: Spare parts search result steps
GivenStories: migration/TTP-582/steps/TTP-571.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
