!-- ----------------
!-- TTP-23953 - (MBMD) EcoFee Testing
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch france
Given is 'D2C' website for brand 'Bosch' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23953 - (MBMD) EcoFee Testing
Scenario: TTP-23953 - (MBMD) EcoFee Testing
GivenStories: localtests/product_information/steps/TTP-23953.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
