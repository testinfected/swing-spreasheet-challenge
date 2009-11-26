package test.unit.spreadsheet.ui;

import org.junit.Test;

import static java.math.BigDecimal.valueOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import spreadsheet.ui.Coordinates;

public class CoordinatesTest {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE = ALPHABET.length();

    private static Object[][] dataPoints = {
            { 0, 0, "A1" },
            { 98, 25, "Z99" },
            { 0, 26, "AA1"},
            { 0, n('Z') * base(1) + n('Z') * base(0) - 1, "ZZ1"},
            { 0, n('A') * base(2) + n('A') * base(1) + n('A') * base(0) - 1, "AAA1"},
            { 9999, n('C') * base(4) + n('Z') * base(3) + n('M') * base(2) + n('H') * base(1) + n('U') * base(0) - 1, "CZMHU10000"}
    };

    @Test public void
    convertsCoordinatesToReference() {
        for (Object[] data : dataPoints) {
            assertThat(Coordinates.at(row(data), col(data)).reference(), equalTo(ref(data)));
        }
    }

    private static int n(char letter) {
        return ALPHABET.indexOf(letter) + 1;
    }

    private static int base(int n) {
        return valueOf(BASE).pow(n).intValue();
    }

    private Integer row(Object[] data) {
        return (Integer) data[0];
    }

    private Integer col(Object[] data) {
        return (Integer) data[1];
    }

    private String ref(Object[] data) {
        return (String) data[2];
    }
}
