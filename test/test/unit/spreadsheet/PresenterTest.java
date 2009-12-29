package test.unit.spreadsheet;

import org.junit.Before;
import org.junit.Test;

import spreadsheet.EditionListener;
import spreadsheet.EditorView;
import spreadsheet.GridPresenter;
import spreadsheet.GridListener;
import spreadsheet.GridView;
import static org.junit.Assert.*;

public class PresenterTest implements GridView, EditorView {

    private String received;

    @Before
    public void resetReceived() {
    	received = null;
    }
    
    
    @Test
    public void ShouldBeAGridListener() {
        assertTrue(new GridPresenter() instanceof GridListener);
    }

    @Test
    public void shouldUpdateTheInputLineWhenNotified() {
        GridPresenter presenter = new GridPresenter();
        presenter.setGridView(this);
        presenter.cellClicked("toto");
        assertEquals("toto", received);
    }

    @Test
    public void shouldSendEmptyStringWhenCellIsNull() {
        GridPresenter presenter = new GridPresenter();
        presenter.setGridView(this);
        presenter.cellClicked(null);
        assertEquals("", received);
    }

    public void updateInputLine(String value) {
        received = value;
    }

    public void registerGridViewListener(GridListener gridListener) {
        
    }
    
    @Test
    public void shouldBeAEditionListener() {
    	assertTrue(new GridPresenter() instanceof EditionListener);
    }
    
    @Test
    public void shouldUpdateTheSelectedCellWhenNotified() {
    	GridPresenter presenter = new GridPresenter();
        presenter.setEditorView(this);
        presenter.valueChanged("new value");
        assertEquals("new value", received);
    }

	public void registerEditionListener(EditionListener editionListener) {
		
	}

	public void updateSelectedCell(String value) {
		received = value;
	}


	public GridListener getGridListener() {
		// TODO Auto-generated method stub
		return null;
	}


	public EditionListener getEditionListener() {
		// TODO Auto-generated method stub
		return null;
	}


}