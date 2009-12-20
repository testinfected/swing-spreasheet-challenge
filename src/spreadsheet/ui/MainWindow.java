package spreadsheet.ui;

import java.awt.*;

import javax.swing.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import spreadsheet.GridListener;
import spreadsheet.GridView;
import spreadsheet.Sheet;

public class MainWindow extends JFrame implements GridView {
    public static final String MAIN_WINDOW_NAME = "Spreadsheet 1.0 beta";
    public static final String APPLICATION_TITLE = "Spreadsheet";
    public static final String INPUT_LINE_NAME = "input line";

    private final int rows;
    private final int columns;

    private GridListener gridListener;
    private JTextField inputLine;

    public MainWindow(int rows, int columns) {
        super(APPLICATION_TITLE);
        this.rows = rows;
        this.columns = columns;
        setName(MAIN_WINDOW_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showMainWindow() {
        fillContentPane(createDefaultSheet(), createFormulaBar());
        pack();
        setVisible(true);
    }

    private void fillContentPane(JTable sheet, JPanel formulaBar) {
        final Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(formulaBar, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(sheet), BorderLayout.CENTER);
    }

    private JTable createDefaultSheet() {
    	final JTable table = new JTable(new GridTableModel(new Sheet(), rows, columns));
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent arg0) {
                Object content = table.getValueAt(
                        table.getSelectionModel().getLeadSelectionIndex(),
                        table.getColumnModel().getSelectionModel().getLeadSelectionIndex());
                gridListener.cellClicked(content);
            }
        });
        return table;
    }

    private JPanel createFormulaBar() {
        JPanel bar = new JPanel();
        bar.setLayout(new FlowLayout());
        bar.add(inputLineField());
        return bar;
    }

    private JTextField inputLineField() {
        inputLine = new JTextField();
        inputLine.setName(INPUT_LINE_NAME);
        inputLine.setColumns(30);
        return inputLine;
    }

    public void registerGridViewListener(GridListener gridListener) {
        this.gridListener = gridListener;
    }

    public void updateInputLine(String value) {
        inputLine.setText(value);
    }


}
