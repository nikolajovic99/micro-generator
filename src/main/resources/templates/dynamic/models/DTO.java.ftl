package ${basePackage}.dto.${modelNameLower};

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ${modelName}DTO {
    private UUID id;

<#list fields as f>
    private ${f.type} ${f.name};

</#list>
}
