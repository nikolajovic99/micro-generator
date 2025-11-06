package com.github.nikolajovic99.microgenerator.scaffold;

import java.util.List;

public final class Manifest {

    public List<StaticEntry> staticFiles;
    public List<DynamicEntry> dynamic;

    public static final class StaticEntry { public String from, to, mode; }
    public static final class DynamicEntry { public String template, to, repeat; }
}
