!-- ----------------
!-- TTP-119 - Automatic:Login Functionality (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-119 - Automatic:Login Functionality (Siemens)
Scenario: TTP-119 - Automatic:Login Functionality (Siemens)
GivenStories: localtests/myaccount/steps/TTP-119.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
