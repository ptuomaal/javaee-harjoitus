FROM airhacks/wildfly
COPY ./target/ping.war ${DEPLOYMENT_DIR}
