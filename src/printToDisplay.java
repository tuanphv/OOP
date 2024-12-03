public class printToDisplay {
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

    public printToDisplay(String[] headers, String[][] data) {
        printTable(headers, data);
    }
    public void printTable(String[] headers, String[][] data) {
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
    public String formatText(String text, String fgColor, String bgColor) {
        return formatText(text, fgColor, bgColor, "");
    }

    public String formatText(String text, String fgColor, String bgColor, String style) {
        return "\u001B[" + fgColor + ";" + bgColor + (style != "" ? ";" + style : "") + "m" + text + "\u001B[0m";
    }

    public String setLength(String text, int length) {
        return String.format("%-" + length + "s", text);
    }
    //  ║ ╔ ╗ ╚  ╝ ╠  ╣  ╦  ╩  ╬  
    public void printHeader(String[] header, int[] columnWidths) {
        StringBuilder headerString = new StringBuilder("╔");
        for (int i = 0; i < header.length; i++) {
            headerString.append("═".repeat(columnWidths[i] + 2)).append(i == header.length - 1 ? "╗" : "╦");
        }
        System.out.println(headerString);
        StringBuilder headerString1 = new StringBuilder("║");
        for (int i = 0; i < header.length; i++)
            headerString1.append(" ").append(formatText(setLength(header[i], columnWidths[i]), FG_COLOR.GREEN, BG_COLOR.NONE)).append(" ║");
        System.out.println(headerString1);
        StringBuilder headerString2 = new StringBuilder("╠");
        for (int i = 0; i < header.length; i++) {
            headerString2.append("═".repeat(columnWidths[i] + 2)).append(i == header.length - 1 ? "╣" : "╬");
        }
        System.out.println(headerString2);
        
    }
    public void printRow(String[] row, int[] columnWidths) {
        StringBuilder rowString = new StringBuilder("║");
        for (int i = 0; i < row.length; i++)
            rowString.append(" ").append(setLength(row[i], columnWidths[i])).append(" ║");
        System.out.println(rowString);
    }
    public void printFooter(String[] header, int[] columnWidths) {
        StringBuilder headerString = new StringBuilder("╚");
        for (int i = 0; i < header.length; i++) {
            headerString.append("═".repeat(columnWidths[i] + 2)).append(i == header.length - 1 ? "╝" : "╩");
        }
        System.out.println(headerString);
    }
    public static void main(String[] args) {
        String[] headers = { "Name","Age"};
        String[][] data = { { "John", "25" }, { "Sally", "22" }, { "Jane", "30" } };
        new printToDisplay(headers, data);
    }
}
