package csd.calculator.testduplicates;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintStreamFake extends PrintStream {

    public PrintStreamFake() {
        super(new ByteArrayOutputStream(), true);
    }

    public String[] GetStrings() {
        return out.toString().split("\\r\\n");
    }

}
