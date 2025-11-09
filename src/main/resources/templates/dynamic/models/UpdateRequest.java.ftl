package ${basePackage}.dto.${modelNameLower};

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Update${modelName}Request {
<#list fields as f>
    private ${f.type} ${f.name};

</#list>
}
