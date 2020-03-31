!-- ----------------
!-- TTP-336 - Automatic: Competency Pages : Care and Cleaning
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-336 - Automatic: Competency Pages : Care and Cleaning
Scenario: TTP-336 - Automatic: Competency Pages : Care and Cleaning
GivenStories: migration/TTP-656/steps/TTP-336.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
