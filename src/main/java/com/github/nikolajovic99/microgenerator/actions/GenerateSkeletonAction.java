package com.github.nikolajovic99.microgenerator.actions;

import com.github.nikolajovic99.microgenerator.mapping.VarsMapper;
import com.github.nikolajovic99.microgenerator.scaffold.ProjectScaffold;
import com.github.nikolajovic99.microgenerator.yaml.YamlLoader;
import com.github.nikolajovic99.microgenerator.yaml.model.ServiceSpec;
import com.github.nikolajovic99.microgenerator.yaml.model.ServicesRoot;
import com.github.nikolajovic99.microgenerator.util.DesktopPathResolver;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

import org.jetbrains.annotations.NotNull;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public final class GenerateSkeletonAction extends AnAction {

    @Override public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();

        if (project == null) return;

        var descriptor = new FileChooserDescriptor(
                true,
                false,
                false,
                false,
                false,
                false)
                .withTitle("Select Microservices YAML")
                .withFileFilter(f -> f.getName().endsWith(".yml") || f.getName().endsWith(".yaml"));

        var files = FileChooserFactory.getInstance().createFileChooser(descriptor, project, null)
                .choose(project);

        if (files.length == 0) return;

        Path yamlPath = Path.of(files[0].getPath());

        try {
            ServicesRoot root = YamlLoader.load(yamlPath);
            List<ServiceSpec> list = root.getServices();
            if (list == null || list.isEmpty()) {
                Messages.showErrorDialog(project, "No services defined.", "MicroGenerator");
                return;
            }

            Path projectRoot = DesktopPathResolver.resolveDesktop();

            for (ServiceSpec s : list) {
                Map<String, Object> vars = VarsMapper.toVars(s);
                ProjectScaffold.generate(project, projectRoot, vars);
            }

            Messages.showInfoMessage(project, "Generated " + list.size() + " service(s).", "MicroGenerator");
        } catch (Exception ex) {
            Messages.showErrorDialog(project, ex.getMessage(), "MicroGenerator");
        }
    }
}
