package test.unit.spreadsheet.ui;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import spreadsheet.Grid;
import spreadsheet.ui.GridTableModel;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JMock.class)
public class GridTableModelTest {

    private static final int TOTAL_ROWS = 10;
    private static final int TOTAL_COLS = 26;

    private final Mockery context = new Mockery();
    private Grid grid = context.mock(Grid.class);
    private GridTableModel model = new GridTableModel(grid, TOTAL_ROWS, TOTAL_COLS);

    @Test public void
    hasFixedDimensions() {
        assertThat(model.getRowCount(), equalTo(TOTAL_ROWS));
        assertThat(model.getColumnCount(), equalTo(TOTAL_COLS));
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
    knowsHowToBuildCellReferences() {
    	assertThat(model.referenceFor(0, 0), equalTo("A1"));
    	assertThat(model.referenceFor(3, 5), equalTo("F4"));
    }
    
    @Test public void
    readsTableValueFromGridUsingReferences() {
    	context.checking(new Expectations() {{
    		one(grid).get(with("A1"));
    	}});
    	
    	model.getValueAt(0, 0);
    }

    @Test public void
    storesTextRepresentationOfCellContentInGridUsingReference() {
        context.checking(new Expectations() {{
            one(grid).put(with("A1"), with("content"));
        }});

        model.setValueAt("content", 0, 0);
    }

}
