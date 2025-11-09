<#assign db = database.type>
package ${basePackage}.repository;

<#if db == "postgresql" || db == "mysql"  || db == "mariadb" || db == "oracle" || db == "sqlserver">
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
</#if>
<#if db == "mongodb">
import org.springframework.data.mongodb.repository.MongoRepository;
</#if>

import ${basePackage}.model.${modelName};

<#if db == "postgresql" || db == "mysql"  || db == "mariadb" || db == "oracle" || db == "sqlserver">
@Repository
public interface ${modelName}Repository extends JpaRepository<${modelName}, UUID> {
}
</#if>
<#if db == "mongodb">
public interface ${modelName}Repository extends MongoRepository<${modelName}, String> {
}
</#if>
