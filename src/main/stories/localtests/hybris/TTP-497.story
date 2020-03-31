!-- ----------------
!-- TTP-497 - Automatic: HMC - Sync Job with error
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for  
Given is 'D2C' website for brand '' and country ''
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-497 - Automatic: HMC - Sync Job with error
Scenario: TTP-497 - Automatic: HMC - Sync Job with error
GivenStories: localtests/hybris/steps/TTP-497.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
