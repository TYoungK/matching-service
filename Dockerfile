FROM ubuntu:24.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y \
    openjdk-21-jdk \
    mysql-server \
    wget \
    curl \
    unzip \
    && rm -rf /var/lib/apt/lists/*

ENV MYSQL_ROOT_PASSWORD=0000
RUN sed -i 's/^bind-address\s*=.*/bind-address = 0.0.0.0/' /etc/mysql/mysql.conf.d/mysqld.cnf

EXPOSE 3306 8080

WORKDIR /app

COPY build/libs/*.jar /app/app.jar

COPY init.sql /app/init.sql

CMD bash -c "\
    service mysql start && \
    echo 'Waiting for MySQL to initialize...' && \
    sleep 10 && \
    mysql -uroot -p${MYSQL_ROOT_PASSWORD} < /app/init.sql && \
    echo 'MySQL initialized!' && \
    java -jar /app/app.jar"