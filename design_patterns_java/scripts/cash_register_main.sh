#!/bin/bash

ROOT=".."
javac -sourcepath $ROOT/src/ $ROOT/src/main/dp/creation/singleton/Main.java -d $ROOT/build
java -enableassertions -classpath $ROOT/build main.dp.creation.singleton.Main
