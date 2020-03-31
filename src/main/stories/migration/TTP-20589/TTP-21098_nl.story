!-- ----------------
!-- TTP-21098 - Neff/Balay - (MBMD) - BAS3 - Fulltext Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay netherlands
Given is 'D2C' website for brand 'Balay' and country 'netherlands'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21098 - Neff/Balay - (MBMD) - BAS3 - Fulltext Search
Scenario: TTP-21098 - Neff/Balay - (MBMD) - BAS3 - Fulltext Search
GivenStories: migration/TTP-20589/steps/TTP-21098.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
