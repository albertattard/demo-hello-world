FROM container-registry.oracle.com/os/oraclelinux:9-slim AS base

FROM base AS base-arm64
RUN curl --silent --show-error --fail --location --output '/tmp/jdk.rpm' 'https://download.oracle.com/java/25/latest/jdk-25_linux-aarch64_bin.rpm' \
 && echo 'a63e12652fb33d5c9b55200ebe6a67e4e12360afbe000c5ff347c562c9192415 /tmp/jdk.rpm' | sha256sum --check \
 && rpm -i '/tmp/jdk.rpm' \
 && rm '/tmp/jdk.rpm'

FROM base AS base-amd64
RUN curl --silent --show-error --fail --location --output '/tmp/jdk.rpm' 'https://download.oracle.com/java/25/latest/jdk-25_linux-x64_bin.rpm' \
 && echo 'f13a81bc8ca2a9478e130b1212b4909d16a8bdeba8d77c03fa0c3de9a8b1861e /tmp/jdk.rpm' | sha256sum --check \
 && rpm -i '/tmp/jdk.rpm' \
 && rm '/tmp/jdk.rpm'

FROM base-${TARGETARCH}
WORKDIR /opt/app
ARG BUILD_REF
COPY ./target/app-${BUILD_REF}.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-jar", "app.jar"]
