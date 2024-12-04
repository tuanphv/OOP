package Sach;
public class SachHocThuat extends Sach {
    private String linhVucNC;
    private String trinhDoHV;

    public SachHocThuat() {
    }

    public SachHocThuat(String maSach, String tenSach, String maNXB, String maTG, int namXB, int donGia, int soLuong, String trinhDoHV, String linhVucNC) {
        super(maSach, tenSach, maNXB, maTG, namXB, donGia, soLuong);
        this.linhVucNC = linhVucNC;
        this.trinhDoHV = trinhDoHV;
    }

    public SachHocThuat(SachHocThuat sht1) {
        super((Sach) sht1);
        this.linhVucNC = sht1.linhVucNC;
        this.trinhDoHV = sht1.trinhDoHV;
    }

    public SachHocThuat(Sach s1, String trinhDoHV, String linhVucNC) {
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
        System.out.printf("%-20s%s\n", "Trinh do hoc van:", trinhDoHV);
        System.out.printf("%-20s%s\n", "Linh vuc nghien cuu:", linhVucNC);
    }
    
    @Override
    public String toString() {
        return "1, " + super.toString() + ", " + trinhDoHV + ", " + linhVucNC;
    }

    @Override
    public String[] toArray() {
        String[] arr = new String[super.toArray().length + 2];
        System.arraycopy(super.toArray(), 0, arr, 0, super.toArray().length);
        arr[arr.length - 2] = trinhDoHV;
        arr[arr.length - 1] = linhVucNC;
        return arr;
    }
}
