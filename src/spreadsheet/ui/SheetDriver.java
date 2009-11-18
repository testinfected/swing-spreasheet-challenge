package spreadsheet.ui;

import javax.swing.table.AbstractTableModel;

import spreadsheet.Sheet;

public class SheetDriver extends AbstractTableModel {

	private final int rows;
    private final int columns;
	private Sheet sheet;
	
	public SheetDriver(Sheet sheet, int rows, int columns) {
		this.sheet = sheet;
		this.rows = rows;
		this.columns = columns;
	}

	public int getColumnCount() {
		return columns;
	}

	public int getRowCount() {
		return rows;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return sheet.get(null);
	}
	
}