@echo off
call mvn clean install
java -jar .\target\app-3-DI-1-jar-with-dependencies.jar