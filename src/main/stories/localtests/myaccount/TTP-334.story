!-- ----------------
!-- TTP-334 - Automatic: My Account: SocialMedia-Login (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch germany
Given is 'D2C' website for brand 'Bosch' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-334 - Automatic: My Account: SocialMedia-Login (Bosch)
Scenario: TTP-334 - Automatic: My Account: SocialMedia-Login (Bosch)
GivenStories: localtests/myaccount/steps/TTP-334.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
