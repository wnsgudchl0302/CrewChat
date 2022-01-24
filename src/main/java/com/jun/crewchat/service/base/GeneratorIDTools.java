package com.jun.crewchat.service.base;

import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.AtomicInteger;

@UtilityClass
public class GeneratorIDTools {

    private static AtomicInteger index = new AtomicInteger();

    public static int nextVal() {
        if (index.get() > 99999) {
            index.set(0);
        }
        return index.getAndIncrement();
    }

    public static String getId(String prefix) {
        return EIDType.NORMAL.getId(prefix);
    }

    public static String getId(String prefix, EIDType idType) {
        return idType.getId(prefix);
    }
}