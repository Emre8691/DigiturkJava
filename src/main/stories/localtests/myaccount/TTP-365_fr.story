!-- ----------------
!-- TTP-365 - Confirmation-Mail not automatable; Automatic: Staffsales MyAccount - Password forgotten
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'STAFF' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-365 - Confirmation-Mail not automatable; Automatic: Staffsales MyAccount - Password forgotten
Scenario: TTP-365 - Confirmation-Mail not automatable; Automatic: Staffsales MyAccount - Password forgotten
GivenStories: localtests/myaccount/steps/TTP-365.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
