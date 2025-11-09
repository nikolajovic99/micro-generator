package com.github.nikolajovic99.microgenerator.codegen;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class TemplateEngine {

    private final Configuration config;

    public TemplateEngine() {
        config = new Configuration(Configuration.VERSION_2_3_32);

        config.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "/templates");
        config.setDefaultEncoding("UTF-8");
        config.setNumberFormat("computer");
    }

    public void renderToFile(String templatePath, java.util.Map<String,Object> model, Path out) {
        try {
            Files.createDirectories(out.getParent());

            try (Writer writer = Files.newBufferedWriter(out)) {
                Template template = config.getTemplate(templatePath);
                template.process(model, writer);
            }
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
