package com.github.nikolajovic99.microgenerator.scaffold;

import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public final class ResourceCopier {

    public static void copy(String resourcePath, Path out, String mode) {
        try (InputStream in = ResourceCopier.class.getResourceAsStream("/templates/" + resourcePath)) {
            Files.createDirectories(out.getParent());

            Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING);

            if ("755".equals(mode)) {
                try {
                    Files.setPosixFilePermissions(out, Set.of(
                            PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE,
                            PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE,
                            PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_EXECUTE
                    ));
                } catch (UnsupportedOperationException ignore) { /* Windows */ }
            }
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
