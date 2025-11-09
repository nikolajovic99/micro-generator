package ${basePackage}.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import ${basePackage}.dto.${modelNameLower}.${modelName}DTO;
import ${basePackage}.dto.${modelNameLower}.Create${modelName}Request;
import ${basePackage}.dto.${modelNameLower}.Update${modelName}Request;
import ${basePackage}.dto.response.MessageResponse;
import ${basePackage}.service.${modelNameLower}.${modelName}Service;

@RestController
@RequestMapping(value = "api/${modelNameLower}s")
@RequiredArgsConstructor
@Validated
public class ${modelName}Controller {
    private final ${modelName}Service ${modelNameLower}Service;

    @PostMapping
    public ResponseEntity<MessageResponse> create(@Valid @RequestBody Create${modelName}Request create${modelName}Request) {
        return ResponseEntity.ok(${modelNameLower}Service.create(create${modelName}Request));
    }

    @GetMapping
    public ResponseEntity<List<${modelName}DTO>> findAll() {
        return ResponseEntity.ok(${modelNameLower}Service.findAll());
    }

    @GetMapping("/{${modelNameLower}Id}")
    public ResponseEntity<${modelName}DTO> findById(@PathVariable UUID ${modelNameLower}Id) {
        return ResponseEntity.ok(${modelNameLower}Service.findById(${modelNameLower}Id));
    }

    @PutMapping("/{${modelNameLower}Id}")
    public ResponseEntity<MessageResponse> update(@PathVariable UUID ${modelNameLower}Id,
                                                  @Valid @RequestBody Update${modelName}Request update${modelName}Request) {
        return ResponseEntity.ok(${modelNameLower}Service.update(${modelNameLower}Id, update${modelName}Request));
    }

    @DeleteMapping("/{${modelNameLower}Id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable UUID ${modelNameLower}Id) {
        return ResponseEntity.ok(${modelNameLower}Service.delete(${modelNameLower}Id));
    }
}
