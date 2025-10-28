FROM container-registry.oracle.com/os/oraclelinux:9-slim AS base

ENV JAVA_HOME=/usr/lib/jvm/jdk-25
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# https://www.oracle.com/java/technologies/downloads/#java25
RUN curl --silent --show-error --fail --location --output '/tmp/jdk-25.tar.gz' 'https://download.oracle.com/java/25/latest/jdk-25_linux-x64_bin.tar.gz'
RUN echo 'a159db241c72f804ec7c862d465f8237e31d36a463e0b86e18f68bc654dcef91 /tmp/jdk-25.tar.gz' | sha256sum --check
RUN rm -rf "${JAVA_HOME}"
RUN mkdir -p "${JAVA_HOME}"
RUN microdnf install -y gzip
RUN tar --extract --file '/tmp/jdk-25.tar.gz' --directory "${JAVA_HOME}" --strip-components 1
RUN rm -f '/tmp/jdk-25.tar.gz'


FROM base
WORKDIR /opt/app
ARG BUILD_REF
COPY ./target/app-${BUILD_REF}.jar app-${BUILD_REF}.jar
EXPOSE 8080
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75", "-jar", "app-${BUILD_REF}.jar"]
