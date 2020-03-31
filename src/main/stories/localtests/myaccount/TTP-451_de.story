!-- ----------------
!-- TTP-451 - Automatic: Socialmedia Checkout Login (NEFF)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Neff germany
Given is 'D2C' website for brand 'Neff' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-451 - Automatic: Socialmedia Checkout Login (NEFF)
Scenario: TTP-451 - Automatic: Socialmedia Checkout Login (NEFF)
GivenStories: localtests/myaccount/steps/TTP-451.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
