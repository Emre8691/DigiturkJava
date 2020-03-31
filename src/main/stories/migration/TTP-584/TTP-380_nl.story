!-- ----------------
!-- TTP-380 - HMC automation; Automatic: Staffsales User Registration
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-380 - HMC automation; Automatic: Staffsales User Registration
Scenario: TTP-380 - HMC automation; Automatic: Staffsales User Registration
GivenStories: migration/TTP-584/steps/TTP-380.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
