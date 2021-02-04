#!/bin/sh
mvn clean package && docker build -t fi.ptuomaal/ping .
docker rm -f ping || true && docker run -d -p 9990:9990 -p 8080:8080 -p 4848:4848 --name ping fi.ptuomaal/ping
