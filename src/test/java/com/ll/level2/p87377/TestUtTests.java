package com.ll.level2.p87377;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestUtTests {
    @Test
    @DisplayName("getAge")
    void t1() {
        int age = TestUt.call(new Person(), "getAge");
        assertThat(age).isEqualTo(10);
    }
}

class Person {
    private int age = 10;
    private String name = "폴";
    private int getAge() { return age; }
    private int getAge(Integer no1) { return age + no1; }
    private int getAge(Integer no1, Integer no2) { return age + no1 + no2; }
    private int getAge(String no1) { return age + Integer.parseInt(no1); }
    private String getName() { return name; }
    private String getName(String subfix) { return name + subfix; }
    private Person getMe() { return this; }
}