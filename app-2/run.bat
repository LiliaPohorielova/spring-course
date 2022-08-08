@echo off
call mvn clean install
java -jar .\target\app-2-jar-with-dependencies.jar