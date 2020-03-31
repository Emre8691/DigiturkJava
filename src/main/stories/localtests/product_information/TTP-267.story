!-- ----------------
!-- TTP-267 - Automatic: Product Detail Page: Power Reviews
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-267 - Automatic: Product Detail Page: Power Reviews
Scenario: TTP-267 - Automatic: Product Detail Page: Power Reviews
GivenStories: localtests/product_information/steps/TTP-267.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
