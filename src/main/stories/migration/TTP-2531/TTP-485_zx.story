!-- ----------------
!-- TTP-485 - Automatic: HMC - Start Sync Job twice
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS zx
Given is 'D2C' website for brand 'SIEMENS' and country 'zx'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-485 - Automatic: HMC - Start Sync Job twice
Scenario: TTP-485 - Automatic: HMC - Start Sync Job twice
GivenStories: migration/TTP-2531/steps/TTP-485.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
