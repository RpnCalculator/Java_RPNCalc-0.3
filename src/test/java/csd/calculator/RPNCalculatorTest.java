package csd.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import csd.calculator.testduplicates.PrintStreamFake;

public class RPNCalculatorTest {

    private PrintStreamFake fakeOutput;
    private RPNCalculator calc;

    @Before
    public void setUp() {
        fakeOutput = new PrintStreamFake();
        calc = new RPNCalculator(fakeOutput);
    }

    private void verifyOutput(final String[] expectedOutput) {
        final String[] consoleOutput = fakeOutput.GetStrings();

        Assert.assertEquals("output line count", expectedOutput.length,
                consoleOutput.length);
        for (int i = 0; i < expectedOutput.length; i++) {
            Assert.assertEquals(expectedOutput[i], consoleOutput[i]);
        }
    }

    @Test
    public final void singlePrintlnWithEmbeddedLF_NoCR_CombinedString() {
        final String[] expectedOutput = { "Hello World\nToday is a great day to code." };

        calc.println(expectedOutput[0]);

        verifyOutput(expectedOutput);
    }

    @Test
    public final void singlePrintlnWithEmbeddedCRLF_CorrectOutputStrings() {
        final String[] expectedOutput = { "Hello World",
                "Today is a great day to code." };

        calc.println(expectedOutput[0] + "\r\n" + expectedOutput[1]);

        verifyOutput(expectedOutput);
    }

    @Test
    public final void multiplePrintln_CorrectOutputStrings() {
        final String[] expectedOutput = { "Hello World",
                "Today is a great day to code." };

        calc.println(expectedOutput[0]);
        calc.println(expectedOutput[1]);

        verifyOutput(expectedOutput);
    }

}
