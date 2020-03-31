!-- ----------------
!-- TTP-230 - Automatic: MyAccount: My Benefits
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-230 - Automatic: MyAccount: My Benefits
Scenario: TTP-230 - Automatic: MyAccount: My Benefits
GivenStories: migration/TTP-98/steps/TTP-230.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
