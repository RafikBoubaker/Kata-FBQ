package com.sg.kata_backend.domain.service;

import com.sg.kata_backend.domain.model.NumberTransformerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTransformerServiceImplTest {

    private NumberTransformerService transformerService;

    @BeforeEach
    void setUp() {
        transformerService = new NumberTransformerServiceImpl();
    }

    @Test
    void testDivisibleByRules() {

        assertEquals("FOO", transformerService.transform(3));
        assertEquals("FOO", transformerService.transform(9));


        assertEquals("BAR", transformerService.transform(5));
        assertEquals("BAR", transformerService.transform(10));


        assertEquals("FOOBAR", transformerService.transform(15));
    }

    @Test
    void testContainsRules() {

        assertEquals("FOO", transformerService.transform(13));


        assertEquals("BAR", transformerService.transform(52));


        assertEquals("QUIX", transformerService.transform(17));
    }


    @Test
    void testDefaultCase() {

        assertEquals("1", transformerService.transform(1));
        assertEquals("2", transformerService.transform(2));
    }

    @Test
    void testBoundaryConditions() {

        assertEquals("0", transformerService.transform(0));


        assertEquals("100", transformerService.transform(100));
    }

    @Test
    void testInvalidInput() {

        assertThrows(IllegalArgumentException.class, () -> transformerService.transform(-1));
        assertThrows(IllegalArgumentException.class, () -> transformerService.transform(101));
    }


    @Test
    void testComplexCases() {

        assertEquals("FOOBAR", transformerService.transform(30));


        assertEquals("BARQUIX", transformerService.transform(70));
    }
}