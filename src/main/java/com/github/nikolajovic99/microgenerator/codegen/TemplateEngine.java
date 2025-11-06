package com.github.nikolajovic99.microgenerator.codegen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class TemplateEngine {

    private final Configuration cfg;

    public TemplateEngine() {
        cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setNumberFormat("computer");
    }

    public void renderToFile(String templatePath, java.util.Map<String,Object> model, Path out) {
        try {
            Files.createDirectories(out.getParent());

            try (Writer w = Files.newBufferedWriter(out)) {
                Template t = cfg.getTemplate(templatePath);
                t.process(model, w);
            }
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
