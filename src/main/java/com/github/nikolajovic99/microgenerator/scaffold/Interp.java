package com.github.nikolajovic99.microgenerator.scaffold;

import java.util.Map;

public final class Interp {

    public static String sub(String s, Map<String, Object> vars) {
        String out = s;

        for (var v : vars.entrySet()) {
            out = out.replace("${" + v.getKey() + "}", String.valueOf(v.getValue()));
        }

        return out;
    }
}
