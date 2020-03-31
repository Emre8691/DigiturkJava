@REM -----------------------------------------------------------------------------------------------------
@REM 
@REM  webtests - starting bsh webtests
@REM   
@REM  required environment:
@REM   
@REM  set JAVA_HOME to installed jdk directory
@REM   
@REM  set MAVEN_HOME to installed maven directory
@REM   
@REM
@REM  To do not start the selenium server always at first use argument "noserver"
@REM  (if already running the second instance is stopped automatically)   
@REM   
@REM  ----->   .\filename.bat noserver  
@REM 
@REM  To do start the selenium server from local repository use argument "jenkins"
@REM
@REM  ----->   .\filename.bat or ----->   .\filename.bat local
@REM
@REM  To do start the selenium server on jenkins use argument "jenkins"
@REM
@REM  ----->   .\filename.bat jenkins
@REM
@REM
@REM  Additional note:
@REM
@REM  You can copy your individual configuration to webtests/src/main/resources/local.properties
@REM  (a template of this file is located in webtests/src/main/resources/bsh/webtests/config)
@REM
@REM -----------------------------------------------------------------------------------------------------

@echo off


@REM ==== take input if available  ====
SET COMMAND=%1
echo command=%COMMAND%


@REM ==== PRODUCTION WARNING ====
echo.
echo.
echo.###########################################################
echo.
echo ##### YOU ARE SURE TO START WEBTEST ON PRODUCTION ??? #####
echo.
echo.###########################################################
echo.
echo.

timeout /T 10 /NOBREAK


@REM ==== WebTest Setting for SmokeTest on PRODUCTION!!! ====

SET TESTEDSYSTEM=bsh.testedSystem=production
SET METAFILTER=jbehave.meta.filter="-exclude_production, &onlyforproduction, -nostageproduct.exclude checkout_siemens_uk -template_switch.skip *siemens*_de_2013"
SET STORYPATH=jbehave.story.path.pattern="stable/**/*gag*.story,rollout*/**/*siemens_de_2013.story,stable/**/*bosch*.story"
SET BROWSERPATH=selenium.browser.path=%cd%/FirefoxPortable/App/Firefox/firefox.exe

echo.
echo ########## WebTest Settings for Smoke Test ##########
echo.
echo TESTEDSYSTEM: %TESTEDSYSTEM%
echo METAFILTER  : %METAFILTER%
echo STORYPATH   : %STORYPATH%
echo BROWSERPATH : %BROWSERPATH%
echo.


@REM ==== WebTest Setting for SmokeTest via Jenkins Selenium Server ====

SET USE_JENKINS_SELENIUMSERVER=false

IF "%COMMAND%" == "jenkins" (
	SET USE_JENKINS_SELENIUMSERVER=true
	CALL selenium_properties.bat
)

IF "%COMMAND%" == "local" (
	SET USE_JENKINS_SELENIUMSERVER=false
)


@REM ==== START VALIDATION ====

IF "%JAVA_HOME%" == "" (
	echo No JDK found - JAVA_HOME is not set
	exit
)
IF "%MAVEN_HOME%" == "" (
	echo No Maven found - MAVEN_HOME is not set
	exit
)


@REM ==== DO SCRIPT ====

CALL mvn clean compile


@REM ==== Starts SELENIUM STANDALONE SERVER if starting file without goal ====

IF not "%COMMAND%" == "noserver"  (
	IF not "%COMMAND%" == "jenkins" (
		START CMD /C mvn antrun:run -Duse-firefox-portable=true
	)
)

@REM ==== If USE_JENKINS_SELENIUMSERVER is false, webtest will starting on local system with selenium standalone server, else webtest will started by Jenkins ====


IF "%USE_JENKINS_SELENIUMSERVER%" == "false" ( 
	echo.
	echo ########## STARTING selenium server for testing on PRODUCTION ##########
	echo.
	
	timeout /T 15 /NOBREAK
	CALL mvn integration-test -D%TESTEDSYSTEM% -D%METAFILTER% -D%STORYPATH% -D%BROWSERPATH%
	CALL mvn selenium:stop-server
) ELSE (
	echo.
	echo ########## Using selenium server on %JENKINS_SELENIUMSERVER% ##########
	echo.
	
	CALL mvn integration-test -D%TESTEDSYSTEM% -D%METAFILTER% -D%STORYPATH% -D%JENKINS_SELENIUMSERVER% -D%JENKINS_SELENIUMBROWSER% -D%JENKINS_SELENIUMBROWSER_VERSION%
)
	
	
@REM ==== Opens the report file of JBehave as browser tab ====

echo.
echo ########## Open jbehave reports.html to show results ##########
echo.

%cd%\target\jbehave\view\reports.html

echo SCRIPT DONE

