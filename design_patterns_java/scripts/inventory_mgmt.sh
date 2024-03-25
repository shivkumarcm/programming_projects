#!/bin/bash

ROOT=".."
javac -sourcepath $ROOT/src/ -classpath $ROOT/jars/json*.jar $ROOT/src/main/dp/behavioral/command/Main.java -d $ROOT/build
echo $ROOT/build:$ROOT/jars/*.jar
java -enableassertions -classpath $ROOT/jars/*:$ROOT/build main.dp.behavioral.command.Main
