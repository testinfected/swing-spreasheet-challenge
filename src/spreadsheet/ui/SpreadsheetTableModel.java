package spreadsheet.ui;

import spreadsheet.Grid;

import javax.swing.table.AbstractTableModel;

public class SpreadsheetTableModel extends AbstractTableModel {
    private final Grid grid;
    private final int rowCount;
    private final int colCount;

    public SpreadsheetTableModel(Grid grid, int rows, int cols) {
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
    public boolean isCellEditable(int i, int i1) {
        return true;
    }

    public Object getValueAt(int i, int i1) {
        return grid.get();
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        grid.put(String.valueOf(o));
    }
}
