package com.vdtch.calcengine;

public class Main {

    public static void main(String[] args) {

        //useMathEquation();

        String[] statements = {
                "add 1.0", // Error. invalid number of values
                "add xx 25.0", // Error. non-numeric data
                "addX 0.0 0.0", // Error. invalid command
                "divide 100.0 50.0", // 100.0 / 50.0 = 2.0
                "add 25.0 92.0", // 25.0 + 92.0 = 117.0
                "substract 225.0 17.0", // 225.0 - 17.0 = 208.0
                "multiply 11.0 3.0" // 11.0 * 3.0 = 33.0
        };

        CalculateHelper helper = new CalculateHelper();

        for(String statement:statements){
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println(" Original exeception : " + e.getCause().getMessage());
            }
        }

    }

        static void useMathEquation(){

            MathEquation[] equations = new MathEquation[4];
            equations[0] = new MathEquation('d', 100.d, 50.0d);
            equations[1] = new MathEquation('a', 25.d, 92.0d);
            equations[2] = new MathEquation('s', 225.d, 17.0d);
            equations[3] = new MathEquation('m', 11.d, 3.0d);

            for (MathEquation equation : equations) {
                equation.execute();
                System.out.println("result =");
                System.out.println(equation.getResult());
            }

            System.out.println();
            System.out.println("Using Overload");
            System.out.println();

            double leftDouble = 9.0d;
            double rightDouble = 4.0d;
            int leftInt = 9;
            int rightInt = 4;

            MathEquation equationOverload = new MathEquation('d');

            equationOverload.execute(leftDouble, rightDouble);
            System.out.println("Results =");
            System.out.println(equationOverload.getResult());

            equationOverload.execute(leftInt, rightInt);
            System.out.println("Results =");
            System.out.println(equationOverload.getResult());

            equationOverload.execute((double) leftInt, rightInt);
            System.out.println("Results =");
            System.out.println(equationOverload.getResult());

            System.out.println();
            System.out.println("Using Inheritance");
            System.out.println();

            CalculateBase[] calculators = {
                    new Divider(100.0d, 50.0d),
                    new Adder(92.0d, 25.0d),
                    new Subtracter(225.0d, 17.0d),
                    new Multiplier(11.0d, 3.0d)
            };

            for (CalculateBase calculator : calculators) {
                calculator.calculate();
                System.out.println("Result =");
                System.out.println(calculator.getResult());
            }

        }
    }

