public class SachHocThuat extends Sach {
    private String linhVucNC;
    private String trinhDoHV;

    public SachHocThuat() {
    }

    public SachHocThuat(String maSach, String tenSach, String maNXB, String maTG, int namXB, int donGia, int soLuong,
            String theLoai, String linhVucNC, String trinhDoHV) {
        super(maSach, tenSach, maNXB, maTG, namXB, donGia, soLuong, theLoai);
        this.linhVucNC = linhVucNC;
        this.trinhDoHV = trinhDoHV;
    }

    public SachHocThuat(SachHocThuat sht1) {
        super((Sach) sht1);
        this.linhVucNC = sht1.linhVucNC;
        this.trinhDoHV = sht1.trinhDoHV;
    }

    public SachHocThuat(Sach s1, String linhVucNC, String trinhDoHV) {
        super(s1);
        this.linhVucNC = linhVucNC;
        this.trinhDoHV = trinhDoHV;
    }

    public String getLinhVucNC() {
        return linhVucNC;
    }

    public String getTrinhDo() {
        return trinhDoHV;
    }

    public void setLinhVucNC(String linhVucNC) {
        this.linhVucNC = linhVucNC;
    }

    public void setTrinhDo(String trinhDoHV) {
        this.trinhDoHV = trinhDoHV;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Linh vuc nghien cuu: ");
        linhVucNC = in.nextLine();
        System.out.print("Trinh do hoc van: ");
        trinhDoHV = in.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-20s%s\n", "Linh vuc nghien cuu:", linhVucNC);
        System.out.printf("%-20s%s\n", "Trinh do hoc van:", trinhDoHV);
    }
    
    @Override
    public String toString() {
        return String.format("%s%-20s%s", super.toString(), linhVucNC, trinhDoHV);
    }

    @Override
    public String formatToString() {
        return "1, " + super.formatToString() + ", " + linhVucNC + ", " + trinhDoHV;
    }
}
