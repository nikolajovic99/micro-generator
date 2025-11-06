spring.application.name=${name}

server.port=${port}

<#if database?? && database.type??>

  <#if database.type == "postgresql">
spring.datasource.url=jdbc:postgresql://localhost:5432/${database.name}?sslmode=disable
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

  <#elseif database.type == "mysql">
spring.datasource.url=jdbc:mysql://localhost:3306/${database.name}?useSSL=false&serverTimezone=UTC
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

  <#elseif database.type == "mariadb">
spring.datasource.url=jdbc:mariadb://localhost:3306/${database.name}
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

  <#elseif database.type == "oracle">
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/${database.name}
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

  <#elseif database.type == "sqlserver">
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=${database.name}
spring.datasource.username=${database.username}
spring.datasource.password=${database.password}

  <#elseif database.type == "mongodb">
spring.data.mongodb.uri=mongodb://localhost:27017/${database.name}
spring.data.mongodb.database=${database.name}

  <#else>
# Unknown database type: ${database.type}
  </#if>

<#else>
# No database configuration provided
</#if>

<#if database.type != "mongodb">
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
</#if>

logging.level.root=${logging}
