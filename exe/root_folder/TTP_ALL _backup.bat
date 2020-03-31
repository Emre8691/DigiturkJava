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

XCOPY C:\Users\fakioglu\Documents\BSH\webtests\webtests\target\jbehave\* /i

cd  C:\Users\fakioglu\Documents\BSH\webtests\webtests\

SET SYSTEM=futureint
SET SERVER=noserver

SET STORYPATH=jbehave.story.path.pattern=migration/TTP-137.story
SET SELENIUM=selenium.url=http://localhost:7746/wd/hub


SET BROWSERPATH=selenium.browser.path=C:/Users/fakioglu/Documents/Ufuk/FirefoxPortable_29/App/Firefox/firefox.exe
SET TESTEDSYSTEM=bsh.testedSystem=%SYSTEM%
SET METAFILTER=jbehave.meta.filter="-missingproducts, -missingpayment.exclude *bosch_us *bosch_be*, -nostageproduct.exclude checkout_siemens_uk, -nodeliveryaddressdeviant.exclude *bosch_be*, -exclude_notready, -template_switch.exclude *siemens_de_2013 *siemens_ch_de_2013*, -template_switch.exclude *siemens_uk_2013*"
       
echo.
echo ---------------------------------------
echo ### WebTest Settings for Smoke Test ###
echo ---------------------------------------
echo.
echo.
echo TESTEDSYSTEM: %TESTEDSYSTEM%
echo METAFILTER  : %METAFILTER%
echo STORYPATH   : %STORYPATH%
echo BROWSERPATH : %BROWSERPATH%
echo SERVER 	 : %SERVER%
echo SELENIUM	 : %SELENIUM%
echo.
echo.
echo ---------------------------------------
CALL C:\BSHWebTests\Maven\bin\mvn clean integration-test -X -D%TESTEDSYSTEM% -D%METAFILTER% -D%STORYPATH% -D%SELENIUM%
echo SCRIPT DONE

