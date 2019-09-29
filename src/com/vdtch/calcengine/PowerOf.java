package com.vdtch.calcengine;

public class PowerOf implements MathProcessing {
    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public char getSymbol() {
        return '^';
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        return Math.pow(leftValue,rightValue) ;
    }
}
