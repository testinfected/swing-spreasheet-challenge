package spreadsheet;

public interface Grid {

	void put(String reference, String content);

	String get(String reference);
}
