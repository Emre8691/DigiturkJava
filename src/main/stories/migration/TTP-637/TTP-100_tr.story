!-- ----------------
!-- TTP-100 - Automatic:User Registration:SocialMedia-Registration (Bosch)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch turkey
Given is 'D2C' website for brand 'Bosch' and country 'turkey' and language 'Turkish'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100 - Automatic:User Registration:SocialMedia-Registration (Bosch)
Scenario: TTP-100 - Automatic:User Registration:SocialMedia-Registration (Bosch)
GivenStories: migration/TTP-637/steps/TTP-100.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
