package com.example.calculator.Tests;

import com.example.calculator.BLL.Interfaces.ISimpleOperations;
import com.example.calculator.BLL.SimpleOperations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleOperationTests {
    private final ISimpleOperations simpleOperations;

    public SimpleOperationTests() {
        simpleOperations = new SimpleOperations();
    }

    @ParameterizedTest()
    @CsvSource({
            "1, 2, 3",
            "0, 0, 0",
            "-1, 1, 0",
            "2.5, 2.5, 5.0",
            "-2, -3, -5"
    })
    public void addition_twoApplicableNumbers_returnsValue(double a, double b, double expected) {
        double result = simpleOperations.additions(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "1, 2, -1",
            "0, 0, 0",
            "-1, 1, -2",
            "2.5, 2.5, 0",
            "-2, -3, 1"
    })
    public void subtract_twoApplicableNumbers_returnsValue(double a, double b, double expected) {
        double result = simpleOperations.subtract(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "1, 2, 2",
            "0, 0, 0",
            "-1, 1, -1",
            "2.5, 2.5, 6.25",
            "-2, -3, 6"
    })
    public void multiply_twoApplicableNumbers_returnsValue(double a, double b, double expected) {
        double result = simpleOperations.multiply(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "2, 1, 0.5",
            "-1, 1, -1",
            "2.5, 2.5, 1",
            "-2, -3, 1.5",
            "2, 10, 5"
    })
    public void divide_twoApplicableNumbers_returnsValue(double a, double b, double expected) {
        double result = simpleOperations.divide(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "0, 3",
            "0, 0",
            "0, 10",
            "0, -2",
            "0, -10"
    })
    public void divide_byZero_throwsInvalidParameterException(double a, double b) {
        assertThrows(InvalidParameterException.class, () -> simpleOperations.divide(a, b));
    }

    @ParameterizedTest()
    @CsvSource({
            "2, 1, 0",
            "-1, 1, -0",
            "-2, -3, -2",
            "3, -2, 1",
            "-3, 2, -1"
    })
    public void modulo_twoApplicableNumbers_returnsValue(double a, double b, double expected) {
        double result = simpleOperations.modulo(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "3, 0",
            "5, 0",
            "0, 0",
            "10, 0",
            "100, 0"
    })
    public void modulo_byZero_throwsInvalidParameterException(double a, double b) {
        assertThrows(InvalidParameterException.class, () -> simpleOperations.modulo(a, b));
    }
}
