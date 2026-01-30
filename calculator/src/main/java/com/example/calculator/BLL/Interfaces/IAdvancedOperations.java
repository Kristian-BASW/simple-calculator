package com.example.calculator.BLL.Interfaces;

import java.security.InvalidParameterException;

public interface IAdvancedOperations {
    /**
     * Takes a to the power of b
     * @param a is the base
     * @param b is the exponent
     */
    double power(double a, int b) throws InvalidParameterException;

    /**
     * Takes the squareRoot of a
     * @param a is the radicand
     */
    double squareRoot(double a) throws InvalidParameterException;
    long factorial(int a) throws InvalidParameterException;
}
