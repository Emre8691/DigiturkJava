!-- ----------------
!-- TTP-11837 - PI - Marketing Product Detail Page - BazaarVoice
!-- ----------------

!-- Prepare location and parameters
Scenario: Set parameters for SIEMENS greatbritain
Given is 'D2C' website for brand 'SIEMENS' and country 'greatbritain'
Given are properties from url, urlsuffix, product, login, checkout, address, page, registration
Given http authentication is provided


!-- ----------------
!-- TTP-11837 - PI - Marketing Product Detail Page - BazaarVoice
Scenario: TTP-11837 - PI - Marketing Product Detail Page - BazaarVoice
GivenStories: /root/bamboo-agent-home/xml-data/build-dir/TTP-TEPCLTF-JCS/webtests_temp_clone67905422463415361/src/main/stories/localtests/product_information/steps/TTP-11837.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
