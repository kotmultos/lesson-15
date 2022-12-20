package org.example;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class FIClassTest {
    private final int[] fibonacciNumbers = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsOdd_odd(int number) {
        assertTrue(FIClass.isOdd(number));
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsOdd_notOdd(int number) {
        assertFalse(FIClass.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30, 50, 100, 250, 0, 1})
    void testGenerateNumber_positive(int number) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Predicate<Integer> predicateCheckInRange = (x) -> x >= 0 && x <= number;

        FIClass.generateNumber(number);
        int result = Integer.parseInt(outContent.toString());

        assertTrue(predicateCheckInRange.test(result));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -20, 0})
    void testGenerateNumber_negative(int number) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FIClass.generateNumber(number);
        int result = Integer.parseInt(outContent.toString());

        assertEquals(0, result);
    }

    @ParameterizedTest
    @EnumSource(value = DAYS_OF_WEEK.class, names = "MON", mode = EnumSource.Mode.INCLUDE)
    void testGetDayOfWeek_returnsMonday(DAYS_OF_WEEK day) {
        assertEquals(day, FIClass.getDayOfWeek());
    }

    @ParameterizedTest
    @EnumSource(value = DAYS_OF_WEEK.class, names = "MON", mode = EnumSource.Mode.EXCLUDE)
    void testGetDayOfWeek_notReturnsNotMonday(DAYS_OF_WEEK day) {
        assertNotEquals(day, FIClass.getDayOfWeek());
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.56, 3.78, 4.69, 5.49999, 10.5, 5.45})
    void testDoubleToLong_higherRounding(double number) {
        assertEquals(Math.ceil(number), FIClass.doubleToLong(number));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.225, 5.444, 28.01, 35.399, 134.43999, 25.0, 5.44})
    void testDoubleToLong_lowerRounding(double number) {
        assertEquals(Math.floor(number), FIClass.doubleToLong(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void testFibonacci(int number) {
        assertEquals(fibonacciNumbers[number], FIClass.fibonacci(number));
    }
}