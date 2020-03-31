!-- ----------------
!-- TTP-129 - Automatic:Password Forgotten (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-129 - Automatic:Password Forgotten (Siemens)
Scenario: TTP-129 - Automatic:Password Forgotten (Siemens)
GivenStories: localtests/myaccount/steps/TTP-129.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
