!-- ----------------
!-- TTP-301 - Automatic:MyAccount:BGoods LogIn with existing User
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch netherlands
Given is 'D2C' website for brand 'Bosch' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-301 - Automatic:MyAccount:BGoods LogIn with existing User
Scenario: TTP-301 - Automatic:MyAccount:BGoods LogIn with existing User
GivenStories: migration/TTP-98/steps/TTP-301.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
