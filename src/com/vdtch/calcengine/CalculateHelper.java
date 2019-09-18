package com.vdtch.calcengine;

public class CalculateHelper {

    private static final char ADD_SYMBOL = '+';
    private static final char SUBSTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';

    MathCommand command;
    double leftValue;
    double rightvalue;
    double result;

    public void process(String statement) throws InvalidStatementException {
        // add 1.0 2.0
        String[] parts = statement.split(" ");

        if( parts.length != 3)
            throw new InvalidStatementException("Invalid number of parts",statement);

        String commandString = parts[0]; // add

        try {
            leftValue = Double.parseDouble(parts[1]); // 1.0
            rightvalue = Double.parseDouble(parts[2]); // 2.0
        } catch (NumberFormatException e) {
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }

        setCommandFromString(commandString);
        if (command == null)
            throw new InvalidStatementException("Invalid command", statement);

        CalculateBase calculator = null;

        switch (command) {
            case Add:
                calculator = new Adder(leftValue,rightvalue);
                break;
            case Substract:
                calculator = new Subtracter(leftValue,rightvalue);
                break;
            case Divide:
                calculator = new Divider(leftValue,rightvalue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue,rightvalue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();

    }

    private void setCommandFromString (String commandFromString) {
        // add -> MathCommand.Add
        if (commandFromString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if (commandFromString.equalsIgnoreCase(MathCommand.Substract.toString()))
            command = MathCommand.Substract;
        else if (commandFromString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if (commandFromString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;

    }

    @Override
    public String toString() {
        // 1.0 + 2.0 = 3.0
        char symbol = ' ';

        switch (command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
            case Substract:
                symbol = SUBSTRACT_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightvalue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }
    }

