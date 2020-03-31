!-- ----------------
!-- TTP-698 - Production: Siemens Marketing Search
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS germany
Given is 'D2C' website for brand 'SIEMENS' and country 'germany'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-698 - Production: Siemens Marketing Search
Scenario: TTP-698 - Production: Siemens Marketing Search
GivenStories: /root/bamboo-agent-home/xml-data/build-dir/TTP-TEPCLTF-JCS/webtests_temp_clone6500972835526261432/src/main/stories/localtests/m.onsite_search/steps/TTP-698.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
