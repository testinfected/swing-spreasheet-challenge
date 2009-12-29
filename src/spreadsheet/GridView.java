package spreadsheet;

public interface GridView {

    public void registerGridViewListener(GridListener gridListener);

    public void updateInputLine(String value);

	public GridListener getGridListener();
}
