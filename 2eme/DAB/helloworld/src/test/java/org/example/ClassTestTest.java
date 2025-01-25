package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassTestTest {
    ClassTest test = new ClassTest();

    @Test
    void multiply() {
        assertEquals(100, test.multiply(10, 10));
    }
}