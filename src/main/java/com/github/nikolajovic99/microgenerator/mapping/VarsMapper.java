package com.github.nikolajovic99.microgenerator.mapping;

import com.github.nikolajovic99.microgenerator.yaml.model.*;
import java.util.*;

public final class VarsMapper {

    public static Map<String,Object> toVars(ServiceSpec s) {
        Map<String,Object> vars = new HashMap<>();

        vars.put("name", s.getName());
        vars.put("group", s.getGroup());
        vars.put("artifact", s.getArtifact());
        vars.put("version", s.getVersion());
        vars.put("description", s.getDescription());
        vars.put("port", s.getPort());
        vars.put("logging", s.getLogging());

        String basePackage = s.getGroup() + "." + s.getArtifact();
        vars.put("basePackage", basePackage);

        String basePackagePath = basePackage.replace('.', '/');
        vars.put("basePackagePath", basePackagePath);

        String appBaseName = toPascal(s.getArtifact());
        vars.put("appBaseName", appBaseName);

        if (s.getDatabase() != null) {
            Map<String,Object> db = new HashMap<>();

            db.put("type", s.getDatabase().getType());
            db.put("name", s.getDatabase().getName());
            db.put("username", s.getDatabase().getUsername());
            db.put("password", s.getDatabase().getPassword());

            vars.put("database", db);
        }

        if (s.getDependencies() != null) {
            List<Map<String,Object>> deps = new ArrayList<>();

            for (DependencySpec d : s.getDependencies()) {
                Map<String,Object> map = new HashMap<>();

                map.put("groupId", d.getGroupId());
                map.put("artifactId", d.getArtifactId());

                if (d.getScope()!=null && !d.getScope().isBlank()) map.put("scope", d.getScope());
                if (d.getVersion()!=null && !d.getVersion().isBlank()) map.put("version", d.getVersion());

                deps.add(map);
            }

            vars.put("dependencies", deps);
        }

        var modelMaps = new ArrayList<Map<String,Object>>();

        if (s.getModels() != null) {
            for (var m : s.getModels()) {
                var map = new HashMap<String,Object>();

                String modelName = toPascal(m.getName());
                map.put("modelName", modelName);

                String modelNameLower = m.getName().toLowerCase().replaceAll("[^a-z0-9]+", "");
                map.put("modelNameLower", modelNameLower);

                map.put("tableName", m.getTable());

                var fieldMaps = new ArrayList<Map<String,Object>>();

                for (var f : m.getFields()) {
                    fieldMaps.add(Map.of(
                            "name", f.getName(),
                            "type", f.getType(),
                            "columnName", toColumnName(f.getName()),
                            "fieldNamePascal", toPascal(f.getName())
                    ));
                }

                map.put("fields", fieldMaps);

                modelMaps.add(map);
            }
        }

        vars.put("models", modelMaps);

        return vars;
    }

    private static String toPascal(String s) {
        if (s == null) return "";

        String[] parts = s.split("[^A-Za-z0-9]+");
        StringBuilder sb = new StringBuilder();

        for (String p : parts) {
            if (p.isEmpty()) continue;
            sb.append(Character.toUpperCase(p.charAt(0)));
            if (p.length() > 1) sb.append(p.substring(1));
        }

        return sb.toString();
    }

    private static String toColumnName(String fieldName) {
        if (fieldName == null || fieldName.isBlank()) return "";

        return fieldName
                .replaceAll("([a-z0-9])([A-Z])", "$1_$2")
                .toLowerCase();
    }
}
