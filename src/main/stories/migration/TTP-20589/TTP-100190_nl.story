!-- ----------------
!-- TTP-100177 - (MBMD) - CHE1- Checkout Logged User
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for Bosch france
Given is 'STAFF' website for brand 'Bosch' and country 'france'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-100190 - (MBMD) - CHE1- Checkout Logged User
Scenario: TTP-100190 - (MBMD) - CHE1- Checkout Logged User
GivenStories: migration/TTP-20589/steps/TTP-100190.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
