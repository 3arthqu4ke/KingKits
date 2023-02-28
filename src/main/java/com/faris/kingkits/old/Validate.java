package com.faris.kingkits.old;

public class Validate {
    public static String notEmpty(String string) {
        if (string.isEmpty()) {
            throw new IllegalStateException("Empty string!");
        }

        return string;
    }

}
