echo on
SET SYSTEM=futureint
SET SERVER=noserver

SET STORYPATH=jbehave.story.path.pattern=product/products/**.story
SET SELENIUM=selenium.url=http://localhost:4451/wd/hub

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
CALL C:\BSHWebTests\Maven\bin\mvn integration-test -D%TESTEDSYSTEM% -D%METAFILTER% -D%STORYPATH% -D%SELENIUM%
echo SCRIPT DONE

