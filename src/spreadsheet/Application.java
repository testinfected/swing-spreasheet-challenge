package spreadsheet;

import static java.lang.Integer.parseInt;

import javax.swing.SwingUtilities;

import spreadsheet.ui.MainWindow;

public class Application {

    private static final int ROWS = 0;
    private static final int COLUMNS = 1;

    private final int rows;
    private final int columns;
    protected MainWindow ui;
    protected GridPresenter presenter;

    public static void main(String... args) throws Exception {
        Application main = new Application(parseInt(args[ROWS]), parseInt(args[COLUMNS]));     
        main.start();
    }

    public Application(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        presenter = new GridPresenter();
        ui = new MainWindow(rows, columns);
        presenter.setGridView(ui);
        ui.registerGridViewListener(presenter);
        presenter.setEditorView(ui);
        ui.registerEditionListener(presenter);
    }

    public void start() throws Exception {
        startUserInterface();
    }
 
    private void startUserInterface() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {                
                ui.showMainWindow();
            }
        });
    }

	public GridView getGridView() {
		return ui;
	}

	public EditorView getEditorView() {
		return ui;
	}

	public GridPresenter getPresenter() {
		return presenter;
	}

}
