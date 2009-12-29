package spreadsheet.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import spreadsheet.EditionListener;
import spreadsheet.EditorView;
import spreadsheet.GridListener;
import spreadsheet.GridView;
import spreadsheet.Sheet;

public class MainWindow extends JFrame implements GridView, EditorView {
    public static final String MAIN_WINDOW_NAME = "Spreadsheet 1.0 beta";
    public static final String APPLICATION_TITLE = "Spreadsheet";
    public static final String INPUT_LINE_NAME = "input line";

    private final int rows;
    private final int columns;

    private JTable table;
    private GridListener gridListener;
    private JTextField inputLine;
    private EditionListener editionListener;

    public MainWindow(int rows, int columns) {
        super(APPLICATION_TITLE);
        this.rows = rows;
        this.columns = columns;
        setName(MAIN_WINDOW_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fillContentPane(createDefaultSheet(), createFormulaBar());
    }

    public void showMainWindow() {        
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
    	table = new JTable(new GridTableModel(new Sheet(), rows, columns));
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
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
            	notifyCellClicked();                
            }
        });
    }
    
    private void notifyCellClicked() {
    	Object content = table.getValueAt(selectedRow(), selectedColumn());
        this.gridListener.cellClicked(content);
    }

    public void updateInputLine(String value) {
        inputLine.setText(value);
    }

	public void registerEditionListener(EditionListener editionListener) {
		this.editionListener = editionListener;
		inputLine.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent key) {
        		if (key.getKeyChar() == KeyEvent.VK_ENTER) {
        			notifyValueChanged();
        		}
        	}
		});        
	}
	
	protected void notifyValueChanged() {
		String newValue = inputLine.getText();
		editionListener.valueChanged(newValue);
	}

	public void updateSelectedCell(String value) {
		table.setValueAt(value, selectedRow(), selectedColumn());
	}

	private int selectedColumn() {
		return table.getColumnModel().getSelectionModel().getLeadSelectionIndex();
	}

	private int selectedRow() {
		return table.getSelectionModel().getLeadSelectionIndex();
	}

	public GridListener getGridListener() {
		return gridListener;
	}
	
	public EditionListener getEditionListener() {
		return editionListener;
	}


}
