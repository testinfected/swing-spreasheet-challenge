package spreadsheet.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class MainWindow extends JFrame {
    public static final String MAIN_WINDOW_NAME = "Spreadsheet 1.0 beta";
    public static final String APPLICATION_TITLE = "Spreadsheet";

    private final int rows;
    private final int columns;

    public MainWindow(int rows, int columns) {
        super(APPLICATION_TITLE);
        this.rows = rows;
        this.columns = columns;
        setName(MAIN_WINDOW_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillContentPane(createSingleSheet());
        pack();
        setVisible(true);
    }

    private void fillContentPane(JTable sheet) {
        final Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(sheet), BorderLayout.CENTER);
    }

    private JTable createSingleSheet() {
        return new JTable(new AbstractTableModel() {
            public int getRowCount() {
                return rows;
            }

            public int getColumnCount() {
                return columns;
            }

            public Object getValueAt(int rowIndex, int columnIndex) {
                return null;
            }
        });
    }
}
