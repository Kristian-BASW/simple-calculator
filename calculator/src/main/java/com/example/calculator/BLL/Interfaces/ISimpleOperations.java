package com.example.calculator.BLL.Interfaces;

import java.security.InvalidParameterException;

public interface ISimpleOperations {
    /**
     * Additions the two params
     * Adds the param a to the param b
     */
    double additions(double a, double b);

    /**
     * Subtractions of the two params
     * Subtracts the param a to the param b
     */
    double subtract(double a, double b);
    /**
     * Multiplies the two params
     * Multiplies the param b with the param a
     */
    double multiply(double a, double b);
    /**
     * Divides the two params
     * Divides the param a with the param b
     */
    double divide(double a, double b) throws InvalidParameterException;

    /**
     * Modulo on the two params
     * Meaning a modulo b
     */
    double modulo(double a, double b);
}
