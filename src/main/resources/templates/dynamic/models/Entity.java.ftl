<#assign db = database.type>
package ${basePackage}.model;

import lombok.*;

<#if db == "mongodb">
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
</#if>
<#if db == "postgresql" || db == "mysql"  || db == "mariadb" || db == "oracle" || db == "sqlserver">
import jakarta.persistence.*;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
</#if>
<#if db == "mysql" || db == "mariadb" || db == "oracle">
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
</#if>

<#if db == "postgresql" || db == "mysql"  || db == "mariadb" || db == "oracle" || db == "sqlserver">
@Entity
@Table(name = "${tableName}")
</#if>
<#if db == "mongodb">
@Document(collection = "${tableName}")
</#if>
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ${modelName} {
  <#if db == "postgresql">
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id", columnDefinition = "UUID", nullable = false, unique = true, updatable = false)
    private UUID id;

  <#elseif db == "mysql">
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id", columnDefinition = "BINARY(16)", nullable = false, unique = true, updatable = false)
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;

  <#elseif db == "mariadb">
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id", columnDefinition = "BINARY(16)", nullable = false, unique = true, updatable = false)
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;

  <#elseif db == "oracle">
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id", columnDefinition = "RAW(16)", nullable = false, unique = true, updatable = false)
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;

  <#elseif db == "sqlserver">
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    @Column(name = "id", columnDefinition = "uniqueidentifier", nullable = false, unique = true, updatable = false)
    private UUID id;

  <#elseif db == "mongodb">
    @Id
    private String id;

  <#else>
    private String id;

  </#if>
  <#list fields as f>
    @Column(name = "${f.columnName}")
    private ${f.type} ${f.name};

  </#list>
}
