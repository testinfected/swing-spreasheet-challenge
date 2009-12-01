package spreadsheet.ui;

import java.awt.*;

import javax.swing.*;

import spreadsheet.Sheet;

public class MainWindow extends JFrame {
    public static final String MAIN_WINDOW_NAME = "Spreadsheet 1.0 beta";
    public static final String APPLICATION_TITLE = "Spreadsheet";
    public static final String INPUT_LINE_NAME = "input line";

    private final int rows;
    private final int columns;

    public MainWindow(int rows, int columns) {
        super(APPLICATION_TITLE);
        this.rows = rows;
        this.columns = columns;
        setName(MAIN_WINDOW_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    	return new JTable(new GridTableModel(new Sheet(), rows, columns));
    }

    private JPanel createFormulaBar() {
        JPanel bar = new JPanel();
        bar.setLayout(new FlowLayout());
        bar.add(inputLineField());
        return bar;
    }

    private JTextField inputLineField() {
        JTextField inputLine = new JTextField();
        inputLine.setName(INPUT_LINE_NAME);
        inputLine.setColumns(30);
        return inputLine;
    }
}
