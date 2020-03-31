!-- ----------------
!-- TTP-11852 - PI - Marketing List Page - EcoFee
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS france
Given is 'D2C' website for brand 'SIEMENS' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11852 - PI - Marketing List Page - EcoFee
Scenario: TTP-11852 - PI - Marketing List Page - EcoFee
GivenStories: localtests/product_information/steps/TTP-11852.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
