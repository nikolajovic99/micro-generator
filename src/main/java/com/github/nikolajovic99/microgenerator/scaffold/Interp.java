package com.github.nikolajovic99.microgenerator.scaffold;

import java.util.Map;

public final class Interp {

    public static String sub(String s, Map<String,Object> vars) {
        String out = s;

        for (var e : vars.entrySet()) {
            out = out.replace("${" + e.getKey() + "}", String.valueOf(e.getValue()));
        }

        return out;
    }
}
