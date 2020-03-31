!-- ----------------
!-- TTP-287 - Automatic: Customer Service : Contact Form 
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'German'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-287 - Automatic: Customer Service : Contact Form 
Scenario: TTP-287 - Automatic: Customer Service : Contact Form 
GivenStories: migration/TTP-593/steps/TTP-287.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
