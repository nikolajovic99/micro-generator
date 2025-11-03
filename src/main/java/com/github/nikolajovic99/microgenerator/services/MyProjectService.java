package com.github.nikolajovic99.microgenerator.services;

import com.github.nikolajovic99.microgenerator.MyBundle;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;

@Service(Service.Level.PROJECT)
public final class MyProjectService {

    private static final Logger LOG = Logger.getInstance(MyProjectService.class);

    private final Project project;

    public MyProjectService(Project project) {
        this.project = project;
        LOG.info(MyBundle.message("projectService", project.getName()));
        LOG.warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.");
    }

    public int getRandomNumber() {
        return 1 + (int) (Math.random() * 100);
    }
}
