package com.vdtch.calcengine;

public class Main {

    public static void main(String[] args) {

        MathEquation[] equations = new MathEquation[4];
        equations[0] = create(100.d, 50.0d, 'd');
        equations[1] = create(25.d, 92.0d, 'a');
        equations[2] = create(225.d, 17.0d, 's');
        equations[3] = create(11.d, 3.0d, 'm');

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result =");
            System.out.println(equation.getResult());
        }
    }

    public static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);

        return equation;
    }
}
