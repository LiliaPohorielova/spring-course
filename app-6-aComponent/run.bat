@echo off
call mvn clean install
java -jar .\target\app-6-aComponent-jar-with-dependencies.jar