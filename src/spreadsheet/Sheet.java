package spreadsheet;


public class Sheet {

	private String value;
    
	public Sheet() {
	}

	public void put(String reference, String content) {
		this.value = content;
	}

	public String get(String reference) {
		return value;
	}

}
