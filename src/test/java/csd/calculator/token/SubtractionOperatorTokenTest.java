package csd.calculator.token;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import csd.calculator.token.operator.OperatorToken;

public class SubtractionOperatorTokenTest {

	@Test
	public final void isValidOperatorSymbol() {
		assertTrue(OperatorToken.isValidOperatorSymbol("-"));
	}

	@Test
	public final void createSubtractionOperatorToken_Success() {
		final String operatorSymbol = "-";
		final OperatorToken operator = OperatorToken
				.createOperatorToken(operatorSymbol);
		assertEquals(operatorSymbol, operator.toString());
	}

	@Test
	public final void subtractionOperatorToken_CanSubtractOperandsSuccessfully() {
		final OperatorToken operator = OperatorToken.createOperatorToken("-");
		final Stack<CalculatorToken> stack = new Stack<CalculatorToken>();
		stack.push(new OperandToken(3.5));
		stack.push(new OperandToken(2.75));
		final OperandToken expected = new OperandToken(0.75);

		assertEquals(expected, operator.execute(stack));
	}
}
