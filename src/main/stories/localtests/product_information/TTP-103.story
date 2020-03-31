!-- ----------------
!-- TTP-103 - Automatic:Product Category Page (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-103 - Automatic:Product Category Page (Siemens)
Scenario: TTP-103 - Automatic:Product Category Page (Siemens)
GivenStories: localtests/product_information/steps/TTP-103.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
