package org.example;

import lombok.Data;

@Data
public class ClassTest {
    String test1;
    String test2;

    public int multiply (int a, int b) {
        return a * b;
    }
}
