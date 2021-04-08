package com.jungle;

import org.springframework.stereotype.Component;

@Component(value = "comTest")
public class Test {
    static {
        System.out.println("test...");
    }
}
