package test.unit.spreadsheet;

import org.junit.Test;
import spreadsheet.GridPresenter;
import spreadsheet.GridListener;
import spreadsheet.GridView;
import static org.junit.Assert.*;

public class PresenterTest implements GridView {

    private String received = null;

    @Test
    public void ShouldBeAGridListener() {
        assertTrue(new GridPresenter() instanceof GridListener);
    }

    @Test
    public void shouldUpdateTheInputLineWhenNotified() {
        GridPresenter presenter = new GridPresenter();
        presenter.setView(this);
        presenter.cellClicked("toto");
        assertEquals("toto", received);
    }

    @Test
    public void shouldSendEmptyStringWhenCellIsNull() {
        GridPresenter presenter = new GridPresenter();
        presenter.setView(this);
        presenter.cellClicked(null);
        assertEquals("", received);
    }

    public void updateInputLine(String value) {
        received = value;
    }

    public void registerGridViewListener(GridListener gridListener) {
        
    }


}