package csd.calculator.token;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import csd.calculator.token.operator.OperatorToken;

public class MultiplicationOperatorTokenTest {

	@Test
	public final void isValidOperatorSymbol() {
		assertTrue(OperatorToken.isValidOperatorSymbol("*"));
	}

	@Test
	public final void createMultiplicationOperatorToken_Success() {
		final String operatorSymbol = "*";
		final OperatorToken operator = OperatorToken
				.createOperatorToken(operatorSymbol);
		assertEquals(operatorSymbol, operator.toString());
	}

	@Test
	public final void multiplicationOperatorToken_CanMultiplyOperandsSuccessfully() {
		final OperatorToken operator = OperatorToken.createOperatorToken("*");
		final Stack<CalculatorToken> stack = new Stack<CalculatorToken>();
		stack.push(new OperandToken(3.5));
		stack.push(new OperandToken(4.0));
		final OperandToken expected = new OperandToken(14.0);

		assertEquals(expected, operator.execute(stack));
	}
}
