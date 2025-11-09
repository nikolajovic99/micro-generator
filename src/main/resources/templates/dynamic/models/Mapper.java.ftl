package ${basePackage}.mapper;

import org.springframework.stereotype.Component;

import ${basePackage}.dto.${modelNameLower}.${modelName}DTO;
import ${basePackage}.model.${modelName};

@Component
public class ${modelName}Mapper {
    public ${modelName}DTO toDto(${modelName} ${modelNameLower}) {
        if (${modelNameLower} == null) return null;

        return ${modelName}DTO.builder()
                .id(${modelNameLower}.getId())
            <#list fields as f>
                .${f.name}(${modelNameLower}.get${f.fieldNamePascal}())
            </#list>
                .build();
    }

    public ${modelName} toEntity(${modelName}DTO ${modelNameLower}DTO) {
        if (${modelNameLower}DTO == null) return null;

        return ${modelName}.builder()
                .id(${modelNameLower}DTO.getId())
            <#list fields as f>
                .${f.name}(${modelNameLower}DTO.get${f.fieldNamePascal}())
            </#list>
                .build();
    }
}
