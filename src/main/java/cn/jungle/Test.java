package cn.jungle;

import org.springframework.stereotype.Component;

@Component(value = "conTest")
public class Test {
    static {
        System.out.println("hhhhhh");
    }
}
