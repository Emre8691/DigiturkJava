!-- ----------------
!-- TTP-362 - Automatic: Staffsales MyAccount - Change delivery address
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'STAFF' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-362 - Automatic: Staffsales MyAccount - Change delivery address
Scenario: TTP-362 - Automatic: Staffsales MyAccount - Change delivery address
GivenStories: migration/TTP-391/steps/TTP-362.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
