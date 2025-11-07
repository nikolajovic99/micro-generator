package ${basePackage}.service.${modelNameLower};

import java.util.List;
import java.util.UUID;

import ${basePackage}.dto.${modelNameLower}.${modelName}DTO;
import ${basePackage}.dto.${modelNameLower}.Create${modelName}Request;
import ${basePackage}.dto.${modelNameLower}.Update${modelName}Request;
import ${basePackage}.dto.response.MessageResponse;

public interface ${modelName}Service {
    MessageResponse create(Create${modelName}Request request);

    List<${modelName}DTO> findAll();

    ${modelName}DTO findById(UUID id);

    MessageResponse update(UUID id, Update${modelName}Request update${modelName}Request);

    MessageResponse delete(UUID id);
}
