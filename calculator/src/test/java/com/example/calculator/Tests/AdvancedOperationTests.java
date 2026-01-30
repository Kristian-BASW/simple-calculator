package com.example.calculator.Tests;

import com.example.calculator.BLL.AdvancedOperations;
import com.example.calculator.BLL.Interfaces.IAdvancedOperations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdvancedOperationTests {
    private IAdvancedOperations _advancedOps;
    public AdvancedOperationTests() {
        _advancedOps = new AdvancedOperations();
    }

    @ParameterizedTest()
    @CsvSource({
            "2, 3, 8",
            "-1, 3, -1",
            "-2, 4, 16",
            "2, -2, 0.25",
            "10, -5, 1e-5",
            "10, -2, 1e-2",
            "10, 2, 100"
    })
    public void power_twoApplicableNumbers_returnsValue(double a, int b, double expected) {
        double result = _advancedOps.power(a, b);
        assertEquals(expected, result, 1e-12);
    }

    @ParameterizedTest()
    @CsvSource({
            "0, -1",
            "0, -10",
            "0, -3"
    })
    public void power_wrongExponent_throwsInvalidParameterException(double a, int b) {
        assertThrows(InvalidParameterException.class, () -> _advancedOps.power(a, b));
    }

    @ParameterizedTest()
    @CsvSource({
            "0, 0",
            "1, 1",
            "4, 2",
            "9, 3",
            "2, 1.41421356237",
            "5, 2.2360679775",
            "100, 10"
    })
    public void squareRoot_twoApplicableNumbers_returnsValue(double a, double expected) {
        double result = _advancedOps.squareRoot(a);
        assertEquals(expected, result, 1e-7);
    }

    @ParameterizedTest()
    @CsvSource({
            "-9",
            "-16",
            "-100"
    })
    public void squareRoot_wrongExponent_throwsInvalidParameterException(double a) {
        assertThrows(InvalidParameterException.class, () -> _advancedOps.squareRoot(a));
    }

    @ParameterizedTest()
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "10, 3628800"
    })
    public void factorial_twoApplicableNumbers_returnsValue(int a, double expected) {
        double result = _advancedOps.factorial(a);
        assertEquals(expected, result);
    }

    @ParameterizedTest()
    @CsvSource({
            "-9",
            "-16",
            "-100"
    })
    public void squareRoot_wrongExponent_throwsInvalidParameterException(int a) {
        assertThrows(InvalidParameterException.class, () -> _advancedOps.factorial(a));
    }
}
