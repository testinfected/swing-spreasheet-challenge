package spreadsheet.ui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import spreadsheet.Sheet;

public class MainWindow extends JFrame {
    public static final String MAIN_WINDOW_NAME = "Spreadsheet 1.0 beta";
    public static final String APPLICATION_TITLE = "Spreadsheet";

    private final int rows;
    private final int columns;
    private JTable table;
    private Sheet sheet;

    public MainWindow(int rows, int columns) {
        super(APPLICATION_TITLE);
        this.rows = rows;
        this.columns = columns;
        setName(MAIN_WINDOW_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillContentPane(createDefaultSheet());
        pack();
        setVisible(true);
    }
    
    private void fillContentPane(JTable sheet) {
        final Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(sheet), BorderLayout.CENTER);
    }
    
    private JTable createDefaultSheet() {
    	return new JTable(new AbstractTableModel() {

			public int getColumnCount() {
				return rows;
			}

			public int getRowCount() {
				return columns;
			}

			public Object getValueAt(int row, int column) {
				return (sheet!=null) ? sheet.getValue() : "";
			}
			
    		public boolean isCellEditable(int row, int column) {
    			return true;
    		}
    		
    		public void setValueAt(Object value, int row, int column) {
				if (sheet != null) sheet.putValue((String) value);
			}
    	});
    }

	public void setActiveSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public Sheet getActiveSheet() {
		return this.sheet;
	}
    
    

}
