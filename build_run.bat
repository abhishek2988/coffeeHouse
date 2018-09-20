set "CURRENT_DIR=%cd%"
cls
call mvn -f pom.xml clean install 
call mvn spring-boot:run -Drun.arguments=--debug
echo Exit Code = %ERRORLEVEL% 
if not "%ERRORLEVEL%" == "0" exit /b
:end
