@echo off
call mvn clean install
java -jar .\target\app-4-scope-jar-with-dependencies.jar