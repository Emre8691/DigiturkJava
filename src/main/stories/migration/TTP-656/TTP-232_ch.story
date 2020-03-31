!-- ----------------
!-- TTP-232 - Automatic: Customer Service : Competency Pages - All About Service
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-232 - Automatic: Customer Service : Competency Pages - All About Service
Scenario: TTP-232 - Automatic: Customer Service : Competency Pages - All About Service
GivenStories: migration/TTP-656/steps/TTP-232.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
