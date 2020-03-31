!-- ----------------
!-- TTP-2467 - [Prod]- Check Adobe Analytics data is sent - 2 option countries - Accept Cookie
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS denmark
Given is 'D2C' website for brand 'SIEMENS' and country 'denmark'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-2467 - [Prod]- Check Adobe Analytics data is sent - 2 option countries - Accept Cookie
Scenario: TTP-2467 - [Prod]- Check Adobe Analytics data is sent - 2 option countries - Accept Cookie
GivenStories: migration/TTP-2530/steps/TTP-2467.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
