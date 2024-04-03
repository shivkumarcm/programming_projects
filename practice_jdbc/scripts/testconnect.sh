#!/bin/bash

rm -rf build
javac -sourcepath ./src/ ./src/mygym/dbconnect/TestConnect.java -d ./build
java -classpath ./build:jars/mysql-connector-j-8.3.0.jar  mygym.dbconnect.TestConnect