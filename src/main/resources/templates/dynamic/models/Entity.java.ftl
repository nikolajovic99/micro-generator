package ${basePackage}.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "${tableName}")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ${modelName} {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

<#list fields as f>
    @Column(name = "${f.columnName}")
    private ${f.type} ${f.name};

</#list>
}
