!-- ----------------
!-- TTP-381 - No HMC automation/No Whitelist-Mails; Automatic: Staffsales User Registration - Whitelisted mail address
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'STAFF' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-381 - No HMC automation/No Whitelist-Mails; Automatic: Staffsales User Registration - Whitelisted mail address
Scenario: TTP-381 - No HMC automation/No Whitelist-Mails; Automatic: Staffsales User Registration - Whitelisted mail address
GivenStories: migration/TTP-2531/steps/TTP-381.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
