@echo off
call mvn clean install
java -jar .\target\app-10-aConfiguration-jar-with-dependencies.jar