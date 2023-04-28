FROM maven:3.10.1-openjdk-17

COPY src/test/java /home/SeleniumTestFramework/src/test/java

COPY src/test/resources /home/SeleniumTestFramework/src/test/resources

COPY pom.xml /home/SeleniumTestFramework

COPY master.xml /home/SeleniumTestFramework

RUN mvn -f /home/SeleniumTestFramework/pom.xml clean test -DskipTests=true