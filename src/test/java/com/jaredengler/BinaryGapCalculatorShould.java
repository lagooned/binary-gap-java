package com.jaredengler;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.any;

public class BinaryGapCalculatorShould {

    BinaryGapCalculator binaryGapCalculator;

    @BeforeEach
    void setup() {
        binaryGapCalculator = new BinaryGapCalculator();
    }

    @Test
    void calculate_returnsSomeInteger() {
        assertThat(binaryGapCalculator.calculate(0), any(Integer.class));
    }

    @Test
    void calculate_returnsCorrectThingFor_lessThan5() {
        assertThat(binaryGapCalculator.calculate(0), is(0));
        assertThat(binaryGapCalculator.calculate(1), is(0));
        assertThat(binaryGapCalculator.calculate(2), is(0));
        assertThat(binaryGapCalculator.calculate(3), is(0));
        assertThat(binaryGapCalculator.calculate(4), is(0));
    }

    @Test
    void calculate_returnsCorrectThingFor_5() {
        assertThat(binaryGapCalculator.calculate(5), is(1)); // 101
    }

    @Test
    void calculate_returnsCorrectThingFor_GreaterThan5LessThan9() {
        assertThat(binaryGapCalculator.calculate(6), is(0)); // 110
        assertThat(binaryGapCalculator.calculate(7), is(0)); // 111
        assertThat(binaryGapCalculator.calculate(8), is(0)); // 1000
    }

    @Test
    void calculate_returnsCorrectThingFor_9() {
        assertThat(binaryGapCalculator.calculate(9), is(2)); // 1001
    }

    @Test
    void calculate_returnsCorrectThingFor_37() {
        assertThat(binaryGapCalculator.calculate(37), is(2)); // 100101
    }

    @Test
    void findPositionOfNextOneFrom_forSomeBinaryStrings() {
        assertThat(binaryGapCalculator.findPositionOfNextOneFrom("11", 0), is(0));
        assertThat(binaryGapCalculator.findPositionOfNextOneFrom("101", 0), is(1));
        assertThat(binaryGapCalculator.findPositionOfNextOneFrom("1001", 0), is(2));
        assertThat(binaryGapCalculator.findPositionOfNextOneFrom("10001", 0), is(3));
        assertThat(binaryGapCalculator.findPositionOfNextOneFrom("100001", 0), is(4));
    }

}
