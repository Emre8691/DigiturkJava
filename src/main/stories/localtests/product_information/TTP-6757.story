!-- ----------------
!-- TTP-6757 - TEST FOR ENRICO Automatic:Product Pages:Product Filter (Shop)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland' and language 'german'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-6757 - TEST FOR ENRICO Automatic:Product Pages:Product Filter (Shop)
Scenario: TTP-6757 - TEST FOR ENRICO Automatic:Product Pages:Product Filter (Shop)
GivenStories: localtests/product_information/steps/TTP-6757.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
