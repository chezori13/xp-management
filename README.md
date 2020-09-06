# xp-management
Experience Management API

Docker
-------
1. At the project path run the following cmd
    ./gradlew bootJar
2. At the project path run the following cmd
    docker build ./ -t xp-management-springbootapp
2. At the project path run the following cmd in the terminal
	docker-compose up
4. The xp-management will be up and running on localhost:8080/experience
5. Postman collection to test the endpoints is provided in postman-collection folder

Build Environment (Manual Way)
------------------------------
1. This Java8 spring-boot project is using gradle to build.
2. If your machine does not have gradle installed, please follow
    https://gradle.org/install/
3. Command to build the project:
    ./gradlew build
4. Command to RUN the project:
    ./gradlew bootRun

5. If there is context load exception when executing ./gradlew bootRun command, it means that connection to Database is not setup yet.
    Please proceed to Datasource Section

Datasource (Manual Way)
-----------------------
1. This project uses PostgreSQL

2. If your machine does not have PostgreSQL installed, please follow
    https://blog.timescale.com/tutorials/how-to-install-psql-on-mac-ubuntu-debian-windows/
3. Once setup is done, open a terminal and enter command
    psql
4. So that you are connected to postgres

5. Open the .sql file in the project path "initdb" folder

6. Copy those .sql file content and paste into the psql terminal.

You should be all set, run the project again.
    ./gradlew bootRun
