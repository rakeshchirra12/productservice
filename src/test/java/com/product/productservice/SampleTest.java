package com.product.productservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest {

    @Test
    void testAdd() {
        /*
        follow 3A's
        Arrange -- create the variables/objects required for testing
        Act -- call the required functions
        Assert -- check the func output to the required output

         */
        int i= 1+3; // Arrange + Act

        assert i == 4;

    }

    @Test
    void testMultiply() {
        int i = 3 * 4;
        assertEquals(12, i, "muliply failed");
    }
}
