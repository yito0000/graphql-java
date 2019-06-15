#!/bin/bash

if [ -d target ]; then
  rm -rf target
fi

mkdir target
mkdir target/dependency
(cd target/dependency; jar -xf ../../build/libs/graphql-java-0.0.1-SNAPSHOT.jar)

