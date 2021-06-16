#!/bin/bash

docker run --name=wldt-cdt-dt \
    -p 8080:8080 \
    -v $(pwd)/logback.xml:/usr/local/src/mvnapp/src/main/resources/logback.xml \
    -v $(pwd)/logback.xml:/usr/local/src/mvnapp/target/classes/logback.xml \
    -d registry.gitlab.com/piconem-university/projects/dt-conduits-zones-iiot/wldt-http-cdt:0.1