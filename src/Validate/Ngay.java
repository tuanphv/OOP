package Validate;
import java.time.LocalDate;

public class Ngay {
    // định dạng dd/mm/yyyy
    private int date;
    private int month;
    private int year;
    public Ngay() {
        LocalDate now = LocalDate.now();
        this.date = now.getDayOfMonth();
        this.month = now.getMonthValue();
        this.year = now.getYear();
    }
    public Ngay(String time) {
        String[] arr = time.split("/");
        this.date = Integer.parseInt(arr[0]);
        this.month = Integer.parseInt(arr[1]);
        this.year = Integer.parseInt(arr[2]);
    }

    public Ngay(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public Ngay(Ngay ngay) {
        this.date = ngay.date;
        this.month = ngay.month;
        this.year = ngay.year;
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

    public int getQuy() {
        return (month - 1) / 3 + 1;
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
     * so sánh ngày hiện tại với ngày truyền vào
     * @param ngay : {@code Ngay} ngày cần so sánh
     * @return
     * return < 0 : this < ngay
     * <p> 
     * return = 0 : this = ngay
     * <p>
     * return > 0 : this > ngay
     */
    public int compare(Ngay ngay) {
        LocalDate date1 = LocalDate.of(this.year, this.month, this.date);
        LocalDate date2 = LocalDate.of(ngay.year, ngay.month, ngay.date);
        return date1.compareTo(date2);
    }
    
    /**
    * Tính số ngày trễ hạn giữa hai đối tượng {@code Ngay}.
    * @param hanTra : {@code Ngay} - ngày hạn trả.
    * @return số ngày trễ hạn. Nếu không trễ, trả về 0.
    */
    //example int soNgayTreHan = ngayTra.soNgayTreHan(hanTra);
    public int soNgayTreHan(Ngay hanTra) {
    LocalDate ngayTra = LocalDate.of(this.year, this.month, this.date);
    LocalDate ngayHanTra = LocalDate.of(hanTra.year, hanTra.month, hanTra.date);

    if (!ngayTra.isAfter(ngayHanTra)) {
        return 0; // Không trễ hạn
    }

    return (int) java.time.temporal.ChronoUnit.DAYS.between(ngayHanTra, ngayTra);
    }
    

    public boolean isBefore(Ngay ngay) {
        return compare(ngay) < 0;
    }
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", date, month, year);
    }
}
