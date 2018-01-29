package csd.calculator.token.operator;

import java.util.Stack;

import csd.calculator.token.CalculatorToken;
import csd.calculator.token.OperandToken;

public class SubtractionOperatorToken extends OperatorToken {

    protected SubtractionOperatorToken() {
        super("-");
    }
    
    @Override
    public CalculatorToken execute(Stack<CalculatorToken> stack) {
        
        if (stack.size() < 2) {
            throw new IllegalArgumentException(getSymbol() + " operation requires 2 operands");
        } 

        Double y = ((OperandToken)stack.pop()).doubleValue();
        Double x = ((OperandToken)stack.pop()).doubleValue();

        return stack.push(new OperandToken(x - y));
        
    }
}
