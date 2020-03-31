!-- ----------------
!-- TTP-97 - Automatic:User Registration:Registration MySiemens
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS switzerland
Given is 'D2C' website for brand 'SIEMENS' and country 'switzerland'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-97 - Automatic:User Registration:Registration MySiemens
Scenario: TTP-97 - Automatic:User Registration:Registration MySiemens
GivenStories: migration/TTP-637/steps/TTP-97.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
