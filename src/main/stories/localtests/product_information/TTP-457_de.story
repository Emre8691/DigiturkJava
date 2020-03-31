!-- ----------------
!-- TTP-457 - Automatic: Productdetail Page (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-457 - Automatic: Productdetail Page (NEFF)
Scenario: TTP-457 - Automatic: Productdetail Page (NEFF)
GivenStories: localtests/product_information/steps/TTP-457.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
