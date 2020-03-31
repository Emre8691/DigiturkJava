!-- ----------------
!-- TTP-206 - Automatic: MyAccount: Product Registration (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-206 - Automatic: MyAccount: Product Registration (Siemens)
Scenario: TTP-206 - Automatic: MyAccount: Product Registration (Siemens)
GivenStories: localtests/myaccount/steps/TTP-206.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
