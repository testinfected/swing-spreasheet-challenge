package test.drivers;

import com.objogate.wl.gesture.Gestures;
import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.*;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.objogate.wl.swing.matcher.JLabelTextMatcher;
import org.hamcrest.Matcher;
import spreadsheet.ui.MainWindow;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

import static com.objogate.wl.swing.matcher.IterableComponentsMatcher.matching;
import static com.objogate.wl.swing.matcher.JLabelTextMatcher.withLabelText;
import static com.objogate.wl.swing.matcher.TableRowCountMatcher.withRowCount;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class SpreadsheetDriver extends JFrameDriver {
    public SpreadsheetDriver(int timeoutInMillis) {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(
                        named(MainWindow.MAIN_WINDOW_NAME),
                        showingOnScreen()),
                new AWTEventQueueProber(timeoutInMillis, 100));
    }

    public void hasColumnsWithTitles(String... titles) {
        JTableHeaderDriver headers = new JTableHeaderDriver(this, JTableHeader.class);
        headers.hasHeaders(matching(labelsFor(titles)));
    }

    public void hasRowCount(int rows) {
        JTableDriver table = new JTableDriver(this, withRowCount(rows));
        table.is(notNullValue());
    }

    public void showsCellWithText(int rowIndex, String columnName, String cellText) {
        JTableDriver table = table();
        table.cellRenderedWithText(rowIndex, columnName, equalToRespectingCase(cellText));
    }

    private Matcher<? extends JComponent>[] labelsFor(String... titles) {
        Collection<JLabelTextMatcher> matchers = new ArrayList<JLabelTextMatcher>();
        for (String title : titles) {
            matchers.add(withLabelText(title));
        }
        return matchers.toArray(new JLabelTextMatcher[titles.length]);
    }

    public void enterTextInCell(int rowIndex, int columnIndex, String content) {
        table().editCell(rowIndex, columnIndex);
        table().performGesture(Gestures.selectAll(), Gestures.type(content), Gestures.typeKey(KeyEvent.VK_ENTER));
    }

    private Matcher<String> equalToRespectingCase(String cellText) {
        return (Matcher<String>) equalTo(cellText);
    }
    
    public void hasOneTab() {
    	JTabbedPaneDriver tabs = new JTabbedPaneDriver(this, JTabbedPane.class);
    	tabs.is(notNullValue());
    	tabs.hasTabCount(1);
    }

    public void activateCell(int rowIndex, int columnIndex) {
        table().selectCell(rowIndex, columnIndex);
    }

    public void showsInInputLine(String literal) {
        textField(MainWindow.INPUT_LINE_NAME).hasText(literal);
    }

    public void enterTextInInputLine(String text) {
        textField(MainWindow.INPUT_LINE_NAME).replaceAllText(text);
    }

    private JTableDriver table() {
        return new JTableDriver(this);
    }

    private JTextFieldDriver textField(String fieldName) {
      JTextFieldDriver textField =
        new JTextFieldDriver(this, JTextField.class, named(fieldName));
      textField.focusWithMouse();
      return textField;
    }
}
