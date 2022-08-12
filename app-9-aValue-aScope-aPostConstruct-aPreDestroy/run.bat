@echo off
call mvn clean install
java -jar .\target\app-9-aValue-aScope-aPostConstruct-aPreDestroy-jar-with-dependencies.jar