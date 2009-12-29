package spreadsheet;



public class GridPresenter implements GridListener, EditionListener {

    private GridView gridView;
    private EditorView editorView;

    public void setGridView(GridView view) {
        this.gridView = view;
    }

    public void setEditorView(EditorView editorView) {
		this.editorView = editorView;
	}

    public GridView getGridView() {
		return gridView;
	}

	public Object getEditorView() {
		return editorView;
	}
	public void cellClicked(Object content) {
        gridView.updateInputLine((content==null) ? "" : content.toString());
    }

	public void valueChanged(String value) {
		editorView.updateSelectedCell(value);
	}

	
}
