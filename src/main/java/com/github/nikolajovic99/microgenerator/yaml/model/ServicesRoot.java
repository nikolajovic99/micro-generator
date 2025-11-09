package com.github.nikolajovic99.microgenerator.yaml.model;

import java.util.List;

public final class ServicesRoot {

    private List<ServiceSpec> services;

    public List<ServiceSpec> getServices() {
        return services;
    }

    public void setServices(List<ServiceSpec> services) {
        this.services = services;
    }
}
