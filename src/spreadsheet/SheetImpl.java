package spreadsheet;

public class SheetImpl implements Sheet {

	private String value;
	
	public String getValue() {
		return value;
	}

	public void putValue(String content) {
		value = content;
	}

}
