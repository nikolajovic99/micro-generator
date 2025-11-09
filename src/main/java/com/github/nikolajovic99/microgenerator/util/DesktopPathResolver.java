package com.github.nikolajovic99.microgenerator.util;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public final class DesktopPathResolver {

    private DesktopPathResolver() {}

    public static Path resolveDesktop() {
        String home = System.getProperty("user.home");

        List<Path> candidates = new ArrayList<>();

        // 1) (Windows/macOS/Linux)
        candidates.add(Paths.get(home, "Desktop"));

        // 2) Windows OneDrive
        String oneDrive = System.getenv("OneDrive");
        if (oneDrive != null && !oneDrive.isBlank()) {
            candidates.add(Paths.get(oneDrive, "Desktop"));
        }

        // 3) Windows fallback
        String userProfile = System.getenv("USERPROFILE");
        if (userProfile != null && !userProfile.isBlank()) {
            candidates.add(Paths.get(userProfile, "Desktop"));
        }

        // 4) Linux XDG
        Path xdg = readXdgDesktopDir(home);
        if (xdg != null) {
            candidates.add(xdg);
        }

        for (Path p : candidates) {
            if (Files.isDirectory(p)) return p;
        }

        Path fallback = Paths.get(home, "Desktop");
        try {
            Files.createDirectories(fallback);
        } catch (IOException ignored) {}
        return fallback;
    }

    private static Path readXdgDesktopDir(String home) {
        Path conf = Paths.get(home, ".config", "user-dirs.dirs");

        if (!Files.isRegularFile(conf)) return null;

        try {
            for (String line : Files.readAllLines(conf)) {
                line = line.trim();

                if (line.startsWith("XDG_DESKTOP_DIR=")) {
                    int eq = line.indexOf('=');

                    if (eq == -1) break;

                    String val = line.substring(eq + 1).trim();

                    val = val.replace("\"", "");
                    val = val.replace("$HOME", home);

                    return Paths.get(val);
                }
            }
        } catch (IOException ignored) {}

        return null;
    }
}
