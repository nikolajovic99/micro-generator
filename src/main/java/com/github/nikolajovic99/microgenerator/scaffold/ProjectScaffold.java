package com.github.nikolajovic99.microgenerator.scaffold;

import com.github.nikolajovic99.microgenerator.codegen.TemplateEngine;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import java.nio.file.Path;
import java.util.Map;

public final class ProjectScaffold {

    public static void generate(Project project, Path projectRoot, Map<String,Object> vars) {
        Manifest manifest = ManifestLoader.load();

        TemplateEngine engine = new TemplateEngine();

        WriteCommandAction.runWriteCommandAction(project, () -> {
            if (manifest.staticFiles != null) {
                for (Manifest.StaticEntry s : manifest.staticFiles) {
                    String to = Interp.sub(s.to, vars);
                    ResourceCopier.copy(s.from, projectRoot.resolve(to), s.mode);
                }
            }

            if (manifest.dynamic != null) {
                for (Manifest.DynamicEntry d : manifest.dynamic) {
                    if (d.repeat == null || d.repeat.isBlank()) {
                        String to = Interp.sub(d.to, vars);
                        engine.renderToFile(d.template, vars, projectRoot.resolve(to));
                    }
                    // (models ponavljanje ćeš dodati kasnije)
                }
            }
        });
    }
}
