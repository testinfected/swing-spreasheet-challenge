package spreadsheet;

import spreadsheet.ui.MainWindow;

import javax.swing.*;

import static java.lang.Integer.parseInt;

public class Application {

    private final int rows;
    private final int columns;

    private MainWindow ui;

    public static void main(String rows, String columns) throws Exception {
        Application main = new Application(parseInt(rows), parseInt(columns));
        main.start();
    }

    public Application(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void start() throws Exception {
        startUserInterface();
    }

    private void startUserInterface() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                ui = new MainWindow(rows, columns);
            }
        });
    }


}
