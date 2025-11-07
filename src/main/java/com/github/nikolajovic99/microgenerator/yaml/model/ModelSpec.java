package com.github.nikolajovic99.microgenerator.yaml.model;

import java.util.List;

public final class ModelSpec {

    private String name;
    private String table;
    private List<FieldSpec> fields;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<FieldSpec> getFields() {
        return fields;
    }

    public void setFields(List<FieldSpec> fields) {
        this.fields = fields;
    }
}
