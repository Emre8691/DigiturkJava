!-- ----------------
!-- TTP-313 - Automatic:Checkout:Payment:Invoice (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-313 - Automatic:Checkout:Payment:Invoice (Siemens)
Scenario: TTP-313 - Automatic:Checkout:Payment:Invoice (Siemens)
GivenStories: migration/TTP-580/steps/TTP-313.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
