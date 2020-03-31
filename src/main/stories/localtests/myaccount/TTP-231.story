!-- ----------------
!-- TTP-231 - Automatic: MyAccount: MyProducts (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-231 - Automatic: MyAccount: MyProducts (Siemens)
Scenario: TTP-231 - Automatic: MyAccount: MyProducts (Siemens)
GivenStories: localtests/myaccount/steps/TTP-231.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
