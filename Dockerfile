FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/clj-wiki.jar /clj-wiki/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/clj-wiki/app.jar"]
