!-- ----------------
!-- TTP-302 - Automatic:Payment: Change Payment Method(Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-302 - Automatic:Payment: Change Payment Method(Siemens)
Scenario: TTP-302 - Automatic:Payment: Change Payment Method(Siemens)
GivenStories: localtests/ecommerce/steps/TTP-302.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
