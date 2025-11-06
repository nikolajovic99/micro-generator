package com.github.nikolajovic99.microgenerator.scaffold;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.InputStream;

public final class ManifestLoader {

    public static Manifest load() {
        try (InputStream in = ManifestLoader.class.getResourceAsStream("/templates/manifest.yml")) {
            if (in == null) {
                throw new IllegalStateException("manifest.yml not found at /templates/manifest.yml on classpath");
            }

            LoaderOptions options = new LoaderOptions();
            // (opciono) options.setAllowDuplicateKeys(false);

            Yaml yaml = new Yaml(new Constructor(Manifest.class, options));
            Manifest m = yaml.load(in);

            if (m == null) throw new IllegalStateException("manifest.yml is empty");

            return m;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load manifest.yml", e);
        }
    }
}
