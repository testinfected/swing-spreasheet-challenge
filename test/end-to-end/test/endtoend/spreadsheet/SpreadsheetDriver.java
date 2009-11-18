package test.endtoend.spreadsheet;

import com.objogate.wl.Query;
import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JTableDriver;
import com.objogate.wl.swing.driver.JTableHeaderDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.objogate.wl.swing.matcher.JLabelTextMatcher;
import org.hamcrest.*;
import spreadsheet.ui.MainWindow;
import test.endtoend.spreadsheet.wl.TableRowCountQuery;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.util.ArrayList;
import java.util.Collection;

import static com.objogate.wl.swing.matcher.IterableComponentsMatcher.matching;
import static com.objogate.wl.swing.matcher.JLabelTextMatcher.withLabelText;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

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

    public void hasLineCount(int lineCount) {
        JTableDriver table = new JTableDriver(this);
        table.has(rowCount(), equalTo(lineCount));
    }

    public void showsCellWithText(int rowIndex, String columnName, String cellText) {
        JTableDriver table = new JTableDriver(this);
        table.cellRenderedWithText(rowIndex, columnName, containsString(cellText));
    }

    private Matcher<? extends JComponent>[] labelsFor(String... titles) {
        Collection<JLabelTextMatcher> matchers = new ArrayList<JLabelTextMatcher>();
        for (String title : titles) {
            matchers.add(withLabelText(title));
        }
        return matchers.toArray(new JLabelTextMatcher[titles.length]);
    }

    private Query<? super JTable, Integer> rowCount() {
        return new TableRowCountQuery();
    }
}
