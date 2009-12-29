package test.unit.spreadsheet;

import org.junit.Before;
import org.junit.Test;

import spreadsheet.Application;
import spreadsheet.EditorView;
import spreadsheet.GridPresenter;
import spreadsheet.GridView;

import static org.junit.Assert.*;


public class ApplicationTest {

	private Application application;
	private GridView gridView;
	private EditorView editorView;
	private GridPresenter presenter;
	
	@Before
	public void startWithANewApplication() {
		application = new Application(10, 10);
		gridView = application.getGridView();
		editorView = application.getEditorView();
		presenter = application.getPresenter();
	}
	
	@Test
	public void shouldLinkPresenterToGrid() {
		assertEquals(presenter, gridView.getGridListener());
		assertEquals(gridView, presenter.getGridView());
	}
	
	@Test
	public void shouldLinkPresenterToEditor() {
		assertEquals(presenter, editorView.getEditionListener());
		assertEquals(editorView, presenter.getEditorView());
	}
}
