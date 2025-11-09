package com.github.nikolajovic99.microgenerator.yaml;

import com.github.nikolajovic99.microgenerator.yaml.model.ServicesRoot;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class YamlLoader {

    public static ServicesRoot load(Path yamlPath) {
        try (InputStream in = Files.newInputStream(yamlPath)) {

            if (in == null) {
                throw new IllegalStateException("YAML file not found: " + yamlPath);
            }

            LoaderOptions options = new LoaderOptions();

            options.setAllowDuplicateKeys(false);
            options.setProcessComments(true);

            Yaml yaml = new Yaml(new Constructor(ServicesRoot.class, options));

            ServicesRoot root = yaml.load(in);

            if (root == null) {
                throw new IllegalStateException("YAML is empty: " + yamlPath);
            }

            return root;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
