!-- ----------------
!-- TTP-21102 - Neff/Balay - (MBMD) - BAS1 - Carousel Shop
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Balay greatbritain
Given is 'D2C' website for brand 'Balay' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-21102 - Neff/Balay - (MBMD) - BAS1 - Carousel Shop
Scenario: TTP-21102 - Neff/Balay - (MBMD) - BAS1 - Carousel Shop
GivenStories: migration/TTP-20589/steps/TTP-21102.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
