!-- ----------------
!-- TTP-23957 - (MBMD) Product Compare Detail Testing
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch unitedarabemirates
Given is 'D2C' website for brand 'Bosch' and country 'unitedarabemirates'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-23957 - (MBMD) Product Compare Detail Testing
Scenario: TTP-23957 - (MBMD) Product Compare Detail Testing
GivenStories: localtests/product_information/steps/TTP-23957.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
