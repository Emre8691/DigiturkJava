!-- ----------------
!-- TTP-482 - Automatic: HMC - Start Sync Job
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-482 - Automatic: HMC - Start Sync Job
Scenario: TTP-482 - Automatic: HMC - Start Sync Job
GivenStories: migration/TTP-2531/steps/TTP-482.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
