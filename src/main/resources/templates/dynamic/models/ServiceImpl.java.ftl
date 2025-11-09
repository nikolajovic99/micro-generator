package ${basePackage}.service.${modelNameLower};

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.*;

import ${basePackage}.dto.${modelNameLower}.${modelName}DTO;
import ${basePackage}.dto.${modelNameLower}.Create${modelName}Request;
import ${basePackage}.dto.response.MessageResponse;
import ${basePackage}.mapper.${modelName}Mapper;
import ${basePackage}.model.${modelName};
import ${basePackage}.repository.${modelName}Repository;
import ${basePackage}.dto.${modelNameLower}.Update${modelName}Request;

@Service
@RequiredArgsConstructor
@Transactional
public class ${modelName}ServiceImpl implements ${modelName}Service {
    private final ${modelName}Repository ${modelNameLower}Repository;

    private final ${modelName}Mapper ${modelNameLower}Mapper;

    @Override
    public MessageResponse create(Create${modelName}Request create${modelName}Request) {
        ${modelName} new${modelName} = ${modelName}.builder()
            <#list fields as f>
                .${f.name}(create${modelName}Request.get${f.fieldNamePascal}())
            </#list>
                .build();

        ${modelNameLower}Repository.save(new${modelName});

        return new MessageResponse("New ${modelNameLower} created successfully.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<${modelName}DTO> findAll() {
        return ${modelNameLower}Repository.findAll()
                .stream()
                .map(${modelNameLower}Mapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ${modelName}DTO findById(UUID id) {
        ${modelName} ${modelNameLower} = ${modelNameLower}Repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("${modelName} not found with id: " + id));

        return ${modelNameLower}Mapper.toDto(${modelNameLower});
    }

    @Override
    public MessageResponse update(UUID id, Update${modelName}Request update${modelName}Request) {
        ${modelName} ${modelNameLower} = ${modelNameLower}Repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("${modelName} not found with id: " + id));

    <#list fields as f>
        ${modelNameLower}.set${f.fieldNamePascal}(update${modelName}Request.get${f.fieldNamePascal}());
    </#list>

        ${modelNameLower}Repository.save(${modelNameLower});

        return new MessageResponse("${modelName} updated successfully.");
    }

    @Override
    public MessageResponse delete(UUID id) {
        if (!${modelNameLower}Repository.existsById(id)) {
            throw new NoSuchElementException("${modelName} not found with id: " + id);
        }

        ${modelNameLower}Repository.deleteById(id);

        return new MessageResponse("${modelName} deleted successfully.");
    }
}
