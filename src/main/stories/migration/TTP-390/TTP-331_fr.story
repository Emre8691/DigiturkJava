!-- ----------------
!-- TTP-331 - Staffsales login (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'STAFF' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-331 - Staffsales login (Siemens)
Scenario: TTP-331 - Staffsales login (Siemens)
GivenStories: migration/TTP-390/steps/TTP-331.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
