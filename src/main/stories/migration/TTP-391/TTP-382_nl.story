!-- ----------------
!-- TTP-382 - Confirmation-Mail not automatable; Automatic: Staffsales User Registration - Friends & Family invitation 
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS netherlands
Given is 'STAFF' website for brand 'SIEMENS' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-382 - Confirmation-Mail not automatable; Automatic: Staffsales User Registration - Friends & Family invitation 
Scenario: TTP-382 - Confirmation-Mail not automatable; Automatic: Staffsales User Registration - Friends & Family invitation 
GivenStories: migration/TTP-391/steps/TTP-382.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
