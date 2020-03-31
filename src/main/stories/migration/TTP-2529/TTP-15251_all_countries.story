!-- ----------------
!-- TTP-15251 - Homeconnect Webservice Test - Get User Data - Update User Data (Prod Pilot RNA)
!-- ----------------

!-- Prepare location and parameters
Scenario: Set webservice url and type
Given is service type is REST
Given is rest base url is https://icore-ws.bsh-partner.com
Given is webservice authentication

!-- ----------------
!-- TTP-15251 - Homeconnect Webservice Test - Get User Data - Update User Data (Prod Pilot RNA)
Scenario: TTP-15251 - Homeconnect Webservice Test - Get User Data - Update User Data (Prod Pilot RNA)
GivenStories: migration/TTP-2529/steps/TTP-15251.steps
!-- ----------------

!-- This line is necessary for the last scenario (a scenario containing only a givenstories construction must not end without a body)
