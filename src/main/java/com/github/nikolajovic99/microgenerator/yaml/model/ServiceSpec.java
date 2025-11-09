package com.github.nikolajovic99.microgenerator.yaml.model;

import java.util.List;

public final class ServiceSpec {

    private String name;
    private String group;
    private String artifact;
    private String version;
    private String description;
    private Integer port;
    private String logging;
    private List<DependencySpec> dependencies;
    private DatabaseSpec database;
    private List<ModelSpec> models;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getLogging() {
        return logging;
    }

    public void setLogging(String logging) {
        this.logging = logging;
    }

    public List<DependencySpec> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<DependencySpec> dependencies) {
        this.dependencies = dependencies;
    }

    public DatabaseSpec getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseSpec database) {
        this.database = database;
    }

    public List<ModelSpec> getModels() {
        return models;
    }

    public void setModels(List<ModelSpec> models) {
        this.models = models;
    }
}
