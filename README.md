# spring-batch-h2

Learn how to setup H2 in-memory database with Spring Boot.

Spring Boot loads SQL from the standard locations schema.sql and data.sql:
http://docs.spring.io/spring-boot/docs/1.5.6.RELEASE/reference/htmlsingle/#howto-initialize-a-database-using-spring-jdbc
It looks like it doesn't work without spring-boot-starter-jdbc dependency.