#!/bin/bash

clear
ROOT=".."
rm -rf $ROOT/build
javac -sourcepath $ROOT/src/ $ROOT/src/main/dp/structural/composite/Main.java -d $ROOT/build
java -classpath $ROOT/build main.dp.structural.composite.Main
