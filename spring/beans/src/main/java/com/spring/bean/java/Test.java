package com.spring.bean.java;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Arrays.asList(TES.values()).stream().forEach(System.out::println);

        Stream.of(TES.values()).collect(Collectors.toMap(TES::getName , TES::getName));
    }
}



enum TES{
    TS(1),
    TTS(1);
    public int name;

    public int getName() {
        return name;
    }

    TES(int name) {
        this.name = name;
    }
}