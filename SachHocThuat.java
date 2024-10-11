public class SachHocThuat extends Sach {
    private String linhVuc;
    private String trinhDoHV;

    public SachHocThuat() {
    }

    public SachHocThuat(String maSach, String tenSach, String maNXB, String maTG, int namXB, int donGia, int soLuong,
            String theLoai, String tinhTrang, String linhVuc, String trinhDoHV) {
        super(maSach, tenSach, maNXB, maTG, namXB, donGia, soLuong, theLoai, tinhTrang);
        this.linhVuc = linhVuc;
        this.trinhDoHV = trinhDoHV;
    }

    public SachHocThuat(SachHocThuat sht1) {
        super((Sach) sht1);
        this.linhVuc = sht1.linhVuc;
        this.trinhDoHV = sht1.trinhDoHV;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public String getTrinhDo() {
        return trinhDoHV;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public void setTrinhDo(String trinhDoHV) {
        this.trinhDoHV = trinhDoHV;
    }

    @Override
    public void nhap() {
        super.nhap();
        linhVuc = in.nextLine();
        trinhDoHV = in.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-25s%s\n", "Linh vuc chuyen nganh:", linhVuc);
        System.out.printf("%-25s%s\n", "Trinh do hoc van:", trinhDoHV);
    }

}
