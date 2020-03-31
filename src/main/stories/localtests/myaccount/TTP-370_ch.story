!-- ----------------
!-- TTP-370 - Automatic: User Registration:SocialMedia-Registration (Siemens)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-370 - Automatic: User Registration:SocialMedia-Registration (Siemens)
Scenario: TTP-370 - Automatic: User Registration:SocialMedia-Registration (Siemens)
GivenStories: localtests/myaccount/steps/TTP-370.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
