package csd.calculator.token;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import csd.calculator.token.operator.OperatorToken;

public class OperatorTokenTest {

	@Test
	public final void isOperator_True() {
		final OperatorToken operator = OperatorToken.createOperatorToken("+");
		assertTrue(operator.isOperator());
	}

	@Test
	public final void toString_returnsTokenSymbolAsString() {
		final OperatorToken operator = OperatorToken.createOperatorToken("+");
		assertEquals("+", operator.toString());
	}
}
