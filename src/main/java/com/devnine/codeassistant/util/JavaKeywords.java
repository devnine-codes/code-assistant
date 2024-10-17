package com.devnine.codeassistant.util;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class JavaKeywords {

    private static final Set<String> JAVA_KEYWORDS = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if",
            "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package",
            "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
    ));

    public static boolean isKeyword(String word) {
        return JAVA_KEYWORDS.contains(word);
    }
}
