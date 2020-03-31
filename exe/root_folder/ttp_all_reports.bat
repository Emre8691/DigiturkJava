echo on
for /f "delims=" %%a in ('wmic OS Get localdatetime  ^| find "."') do set dt=%%a
set YYYY=%dt:~0,4%
set MM=%dt:~4,2%
set DD=%dt:~6,2%
set HH=%dt:~8,2%
set Min=%dt:~10,2%
set Sec=%dt:~12,2%

set stamp=Jbehave_%YYYY%%MM%%DD%@%HH%%Min%
rem you could for example want to create a folder and save backup there
cd C:\Users\fakioglu\testreports
mkdir %stamp%
cd %stamp%

XCOPY C:\Users\fakioglu\bamboo-agent-home\xml-data\build-dir\TTP-BW-BAS\target\jbehave\* /i /s /y