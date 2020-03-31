!-- ----------------
!-- TTP-957 - Testing e-mails(Syntax and Confirmation)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS belgium
Given is 'D2C' website for brand 'SIEMENS' and country 'belgium' and language 'French'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-957 - Testing e-mails(Syntax and Confirmation)
Scenario: TTP-957 - Testing e-mails(Syntax and Confirmation)
GivenStories: migration/TTP-980/steps/TTP-957.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
