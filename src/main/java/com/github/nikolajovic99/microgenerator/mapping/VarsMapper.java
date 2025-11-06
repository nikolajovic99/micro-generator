package com.github.nikolajovic99.microgenerator.mapping;

import com.github.nikolajovic99.microgenerator.yaml.model.*;
import java.util.*;

public final class VarsMapper {

    public static Map<String,Object> toVars(ServiceSpec s) {
        Map<String,Object> v = new HashMap<>();

        v.put("name", s.getName());
        v.put("group", s.getGroup());
        v.put("artifact", s.getArtifact());
        v.put("version", s.getVersion());
        v.put("description", s.getDescription());
        v.put("port", s.getPort());
        v.put("logging", s.getLogging());

        String basePackage = s.getGroup() + "." + s.getArtifact();                  // dotted
        String basePackagePath = basePackage.replace('.', '/');     // slashes
        v.put("basePackage", basePackage);                                          // za .ftl
        v.put("basePackagePath", basePackagePath);                                  // za manifest

        String appBaseName = toPascal(s.getArtifact());                             // Demo

        v.put("appBaseName", appBaseName);                                          // koristiš u manifestu
        v.put("AppClass", appBaseName + "Application");                             // ako ti zatreba u .ftl

        if (s.getDatabase() != null) {
            Map<String,Object> db = new HashMap<>();

            db.put("type", s.getDatabase().getType());
            db.put("name", s.getDatabase().getName());
            db.put("username", s.getDatabase().getUsername());
            db.put("password", s.getDatabase().getPassword());
            v.put("database", db);
        }

        if (s.getDependencies() != null) {
            List<Map<String,Object>> deps = new ArrayList<>();

            for (DependencySpec d : s.getDependencies()) {
                Map<String,Object> m = new HashMap<>();
                m.put("groupId", d.getGroupId());
                m.put("artifactId", d.getArtifactId());
                if (d.getScope()!=null && !d.getScope().isBlank()) m.put("scope", d.getScope());
                if (d.getVersion()!=null && !d.getVersion().isBlank()) m.put("version", d.getVersion());
                deps.add(m);
            }

            v.put("dependencies", deps);
        }

        return v;
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
}
