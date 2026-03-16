FROM tomcat:10.1-jdk17

COPY target/atm-simulation-system.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080