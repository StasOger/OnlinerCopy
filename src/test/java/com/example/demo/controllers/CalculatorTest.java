package com.example.demo.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnSum_whenSum_givenParams() {
// given
        int givenParamOne = 3;
        int givenParamTwo = 5;

        int expected = 8;

// when
        int actual = calculator.sum(givenParamOne, givenParamTwo);

// then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnDel_whenDel_givenParams() {
// given
        int givenParamOne = 30;
        int givenParamTwo = 0;

        int expected = 0;

// when
        int actual = calculator.del(givenParamOne, givenParamTwo);

// then
        Assert.assertEquals(actual, expected);
    }
}