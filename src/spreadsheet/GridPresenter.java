package spreadsheet;


public class GridPresenter implements GridListener {

    private GridView view;

    public void cellClicked(Object content) {
        view.updateInputLine((content==null) ? "" : content.toString());
    }

    public void setView(GridView view) {
        this.view = view;
    }

}
