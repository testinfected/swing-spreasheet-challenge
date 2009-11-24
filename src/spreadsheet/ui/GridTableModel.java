package spreadsheet.ui;

import spreadsheet.Grid;

import javax.swing.table.AbstractTableModel;

public class GridTableModel extends AbstractTableModel {
    private final Grid grid;
    private final int rowCount;
    private final int colCount;

    public GridTableModel(Grid grid, int rows, int cols) {
        this.grid = grid;
        this.rowCount = rows;
        this.colCount = cols;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return colCount;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public Object getValueAt(int row, int col) {
        return grid.get(referenceFor(row, col));
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        grid.put(referenceFor(row, col), String.valueOf(value));
    }

    private String referenceFor(int row, int column) {
        return String.format("(%d,%d)", row, column);
    }

}
