FROM container-registry.oracle.com/os/oraclelinux:9-slim AS base

RUN curl --silent --show-error --fail --location --output '/tmp/jdk.rpm' 'https://download.oracle.com/java/25/latest/jdk-25_linux-x64_bin.rpm' \
 && echo 'f13a81bc8ca2a9478e130b1212b4909d16a8bdeba8d77c03fa0c3de9a8b1861e /tmp/jdk.rpm' | sha256sum --check \
 && rpm -i '/tmp/jdk.rpm' \
 && rm '/tmp/jdk.rpm'

WORKDIR /opt/app
COPY ./target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]
