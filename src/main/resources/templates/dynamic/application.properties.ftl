<#assign db = database.type>
spring.application.name=${name}

server.port=${port}

<#if db == "postgresql">
spring.datasource.url=jdbc:postgresql://localhost:5432/${database.name}?sslmode=disable
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

<#elseif db == "mysql">
spring.datasource.url=jdbc:mysql://localhost:3306/${database.name}?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

<#elseif db == "mariadb">
spring.datasource.url=jdbc:mariadb://localhost:3306/${database.name}?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

<#elseif db == "oracle">
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/${database.name}
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

<#elseif db == "sqlserver">
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=${database.name};encrypt=false;trustServerCertificate=true
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

<#elseif db == "mongodb">
spring.data.mongodb.uri=mongodb://localhost:27017/${database.name}
spring.data.mongodb.database=${database.name}

<#else>
# Unsupported database type: ${database.type}

</#if>
<#if db == "postgresql" || db == "mysql"  || db == "mariadb" || db == "oracle" || db == "sqlserver">
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update

</#if>
logging.level.root=${logging}
