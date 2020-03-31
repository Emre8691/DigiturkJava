!-- ----------------
!-- TTP-15247 - Homeconnect Webservice Login V1(?)-V2 and Customer Service Cleaning - FAQ (Prod Pilot RNA)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set webservice url and type
Given is service type is REST
Given is rest base url is https://icore-ws.bsh-partner.com
Given is webservice authentication

!-- ----------------
!-- TTP-15247 - Homeconnect Webservice Login V1(?)-V2 and Customer Service Cleaning - FAQ (Prod Pilot RNA)
Scenario: TTP-15247 - Homeconnect Webservice Login V1(?)-V2 and Customer Service Cleaning - FAQ (Prod Pilot RNA)
GivenStories: migration/TTP-2529/steps/TTP-15247.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
