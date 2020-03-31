!-- ----------------
!-- TTP-358 - Automatic: ChannelSight Buy.-online-Button on Product List Pages
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-358 - Automatic: ChannelSight Buy.-online-Button on Product List Pages
Scenario: TTP-358 - Automatic: ChannelSight Buy.-online-Button on Product List Pages
GivenStories: migration/TTP-651/steps/TTP-358.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
