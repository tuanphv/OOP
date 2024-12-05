package Format;

import java.util.Scanner;

public class ANSI {
    public class BG_COLOR {
        public static final String BLACK = "40";
        public static final String RED = "41";
        public static final String GREEN = "42";
        public static final String YELLOW = "43";
        public static final String BLUE = "44";
        public static final String PURPLE = "45";
        public static final String CYAN = "46";
        public static final String WHITE = "47";
        public static final String NONE = "49";
    }

    public class FG_COLOR {
        public static final String BLACK = "30";
        public static final String RED = "31";
        public static final String GREEN = "32";
        public static final String YELLOW = "33";
        public static final String BLUE = "34";
        public static final String PURPLE = "35";
        public static final String CYAN = "36";
        public static final String WHITE = "37";
    }

    public class STYLE {
        public static final String BOLD = "1";
        public static final String UNDERLINE = "4";
        public static final String BLINK = "5";
        public static final String REVERSE = "7";
        public static final String CONCEALED = "8";
    }

    private String[] headers;
    private String[][] data;

    public ANSI(String[] headers, String[][] data) {
        this.headers = headers;
        this.data = data;
    }

    public void printTable() {
        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j].length() > columnWidths[j]) {
                    columnWidths[j] = data[i][j].length();
                }
            }
        }
        printHeader(headers, columnWidths);
        for (int i = 0; i < data.length; i++) {
            printRow(data[i], columnWidths);
        }
        printFooter(headers, columnWidths);
    }

    public static String formatText(String text, String fgColor, String bgColor, String style) {
        return "\u001B[" + fgColor + ";" + bgColor + (style != "" ? ";" + style : "") + "m" + text + "\u001B[0m";
    }

    public static String formatText(String text, String fgColor, String bgColor) {
        return formatText(text, fgColor, bgColor, "");
    }

    public static String formatText(String text) {
        return formatText(text, FG_COLOR.YELLOW, BG_COLOR.NONE);
    }

    private String setLength(String text, int length, String alignment) {
        if (text.length() >= length) {
            return text;
        }
        switch (alignment) {
            case "left":
                return String.format("%-" + length + "s", text);
            case "right":
                return String.format("%" + length + "s", text);
            default:
                int padding = (length - text.length()) / 2;
                if (padding == 0) {
                    return setLength(text, length, "left");
                }
                return String.format("%" + padding + "s%s%" + (padding + (length - text.length()) % 2) + "s", "", text, "");
        }
    }

    private void printHeader(String[] header, int[] columnWidths) {
        StringBuilder headerString = new StringBuilder("╔");
        for (int i = 0; i < header.length; i++) {
            headerString.append("═".repeat(columnWidths[i] + 2)).append(i == header.length - 1 ? "╗" : "╦");
        }
        System.out.println(headerString);
        StringBuilder headerString1 = new StringBuilder("║");
        for (int i = 0; i < header.length; i++)
            headerString1.append(" ").append(
                    formatText(setLength(header[i], columnWidths[i], "center"), FG_COLOR.GREEN, BG_COLOR.NONE, STYLE.BOLD)).append(" ║");
        System.out.println(headerString1);
        StringBuilder headerString2 = new StringBuilder("╠");
        for (int i = 0; i < header.length; i++) {
            headerString2.append("═".repeat(columnWidths[i] + 2)).append(i == header.length - 1 ? "╣" : "╬");
        }
        System.out.println(headerString2);

    }

    private void printRow(String[] row, int[] columnWidths) {
        StringBuilder rowString = new StringBuilder("║");
        for (int i = 0; i < row.length; i++)
            rowString.append(" ").append(setLength(row[i], columnWidths[i], "left")).append(" ║");
        System.out.println(rowString);
    }

    private void printFooter(String[] header, int[] columnWidths) {
        StringBuilder headerString = new StringBuilder("╚");
        for (int i = 0; i < header.length; i++) {
            headerString.append("═".repeat(columnWidths[i] + 2)).append(i == header.length - 1 ? "╝" : "╩");
        }
        System.out.println(headerString);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        String[] header = { "Name", "Age" };
        String[][] data = { { "John", "25" }, { "Sally", "22" }, { "Janeft", "30" } };
        new ANSI(header, data).printTable();
    }
}
