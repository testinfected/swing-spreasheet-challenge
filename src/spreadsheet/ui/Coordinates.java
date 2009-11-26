package spreadsheet.ui;

public class Coordinates {
    private static final int BASE = 26;

    private final int row;
    private final int column;

    public static Coordinates at(int row, int column) {
        return new Coordinates(row, column);
    }

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public String reference() {
        return columnName(column) + rowName(row);
    }

    private static String columnName(int column) {
        String name = "";
        for (int n = column; n >= 0; n = n / BASE - 1) {
            name = letter(n % BASE) + name;
        }
        return name;
    }

    private static char letter(int place) {
        return (char) (place + 'A');
    }

    private static String rowName(int row) {
        return String.valueOf(row + 1);
    }
}