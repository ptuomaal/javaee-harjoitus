#!/bin/sh
mvn clean package && cp target/ping.war ~/servers/wildfly-22.0.0.Final/standalone/deployments/
