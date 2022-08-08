@echo off
call mvn clean install
java -jar .\target\app-1-jar-with-dependencies.jar