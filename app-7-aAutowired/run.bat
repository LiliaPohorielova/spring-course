@echo off
call mvn clean install
java -jar .\target\app-7-aAutowired-jar-with-dependencies.jar