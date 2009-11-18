package test.endtoend.spreadsheet.wl;

import com.objogate.wl.Query;
import org.hamcrest.Description;

import javax.swing.*;

public final class TableRowCountQuery implements Query<JTable, Integer> {

      public TableRowCountQuery() {}

      public Integer query(JTable table) {
          return table.getRowCount();
      }

      public void describeTo(Description description) {
          description.appendText("row count");
      }
    }
