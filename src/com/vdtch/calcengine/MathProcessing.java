package com.vdtch.calcengine;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword(); // add
    char getSymbol(); // +
    double doCalculation(double leftValue, double rightValue);
}
