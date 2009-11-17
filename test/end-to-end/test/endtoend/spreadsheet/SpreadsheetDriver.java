package test.endtoend.spreadsheet;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JTableDriver;
import com.objogate.wl.swing.driver.JTableHeaderDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.objogate.wl.swing.matcher.JLabelTextMatcher;
import org.hamcrest.Matcher;
import spreadsheet.ui.MainWindow;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import java.util.ArrayList;
import java.util.List;

import static com.objogate.wl.swing.matcher.IterableComponentsMatcher.matching;
import static com.objogate.wl.swing.matcher.JLabelTextMatcher.withLabelText;

public class SpreadsheetDriver extends JFrameDriver {
    private static final int TOTAL_COLUMNS = 26;

    public SpreadsheetDriver(int timeoutInMillis) {
      super(new GesturePerformer(),
            JFrameDriver.topLevelFrame(
              named(MainWindow.MAIN_WINDOW_NAME),
              showingOnScreen()),
              new AWTEventQueueProber(timeoutInMillis, 100));
    }

    public void hasColumnTitles() {
        JTableHeaderDriver headers = new JTableHeaderDriver(this, JTableHeader.class);
        headers.hasHeaders(matching(alphabet()));
    }

    private Matcher<? extends JComponent>[] alphabet() {
        List<Matcher<? extends JComponent>> matchers = new ArrayList<Matcher<? extends JComponent>>();
        for (char c = 'A'; c <= 'Z'; ++c) {
            matchers.add(withLabelText(String.valueOf(c)));
        }
        return matchers.toArray(new JLabelTextMatcher[TOTAL_COLUMNS]);
    }

    public void hasLines(int lineCount) {
        JTableDriver table = new JTableDriver(this);
    }
}
