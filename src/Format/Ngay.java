package Format;
import java.time.LocalDate;

public class Ngay {
    // định dạng dd/mm/yyyy
    private String time;
    private int date;
    private int month;
    private int year;
    public Ngay() {}
    public Ngay(String time) {
        this.time = time;
        String[] arr = time.split("/");
        this.date = Integer.parseInt(arr[0]);
        this.month = Integer.parseInt(arr[1]);
        this.year = Integer.parseInt(arr[2]);
    }

    public Ngay(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.time = date + "/" + month + "/" + year;
    }

    public Ngay(Ngay ngay) {
        this.date = ngay.date;
        this.month = ngay.month;
        this.year = ngay.year;
        this.time = ngay.time;
    }

    public String getTime() {
        return time;
    }
    public int getDate() {
        return date;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public boolean isValidDate() {
        try {
            LocalDate.of(year, month, date);
            return true;
        } catch (java.time.DateTimeException e) {
            return false;
        }
    }
    /**
     * so sánh 2 ngày
     * @param ngay 'dd/MM/yyyy' ngày cần so sánh
     * @return âm nếu ngày hiện tại trước ngày so sánh, dương nếu ngược lại, 0 nếu bằng nhau
     */
    public int compare(Ngay ngay) {
        LocalDate date1 = LocalDate.of(this.year, this.month, this.date);
        LocalDate date2 = LocalDate.of(ngay.year, ngay.month, ngay.date);
        return date1.compareTo(date2);
    }
    @Override
    public String toString() {
        return time;
    }
}
