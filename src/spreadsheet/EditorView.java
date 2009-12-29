package spreadsheet;

public interface EditorView {

	public void registerEditionListener(EditionListener editionListener);
	
	public void updateSelectedCell(String value);

	public EditionListener getEditionListener();
}
