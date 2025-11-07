package ${basePackage}.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import ${basePackage}.model.${modelName};

@Repository
public interface ${modelName}Repository extends JpaRepository<${modelName}, UUID> {
}
