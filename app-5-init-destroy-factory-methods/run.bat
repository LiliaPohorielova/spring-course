@echo off
call mvn clean install
java -jar .\target\app-5-init-destroy-factory-methods-jar-with-dependencies.jar