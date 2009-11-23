package test.unit.spreadsheet.ui;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import spreadsheet.Grid;
import spreadsheet.ui.SpreadsheetTableModel;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JMock.class)
public class SpreadsheetTableModelTest {

    private static final int TOTAL_ROWS = 10;
    private static final int TOTAL_COLS = 26;

    private final Mockery context = new Mockery();
    private Grid grid = context.mock(Grid.class);
    private SpreadsheetTableModel model = new SpreadsheetTableModel(grid, TOTAL_ROWS, TOTAL_COLS);

    @Test public void
    hasFixedDimensions() {
        assertThat(model.getRowCount(), equalTo(TOTAL_ROWS));
        assertThat(model.getColumnCount(), equalTo(TOTAL_COLS));
    }

    @Test public void
    readsTableValueFromGrid() {
        context.checking(new Expectations() {{
          one(grid).get(); will(returnValue("value in cell"));
        }});

        assertThat(valueOfCell("A1"), is("value in cell"));
    }

    @Test public void
    allCellsAreEditable() {
        for (int row = 0; row < TOTAL_ROWS; row++ ) {
            for (int col = 0; col < TOTAL_COLS; col++) {
                assertThat(model.isCellEditable(row, col), is(true));
            }
        }
    }

    @Test public void
    storesTextRepresentationOfCellContentInGrid() {
        context.checking(new Expectations() {{
            one(grid).put(with("content"));
        }});

        model.setValueAt(anObjectDisplayingAs("content"), 0, 0);
    }

    private String valueOfCell(String reference) {
        return String.valueOf(model.getValueAt(0, 0));
    }

    private Object anObjectDisplayingAs(final String text) {
        return new Object() {
            @Override
            public String toString() {
                return text;
            }
        };
    }
}
