package com.vdtch.calcengine;

public class MathEquation {
    public double leftVal;
    public double rightVal;
    public char opCode;
    public double result;

    public void execute () {
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = rightVal * leftVal;
                break;
            default:
                System.out.println("errir invalide opcaode");
                result = 0.0d;
                break;
        }
    }
}
