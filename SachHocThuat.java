public class SachHocThuat extends Sach {
    private String linhvuc;
    private String trinhdohv;

    public SachHocThuat() {}

    public SachHocThuat(String masach, String tensach, String manxb, String matg, int namxb, int dongia, int soluong, String theloai, String tinhtrang, String linhvuc, String trinhdohv)
    {
        super(masach, tensach, manxb, matg, namxb, dongia, soluong, theloai, tinhtrang);
        this.linhvuc = linhvuc;
        this.trinhdohv = trinhdohv;
    }

    public SachHocThuat(SachHocThuat sht1) 
    {
        super((Sach) sht1);
        this.linhvuc = sht1.linhvuc;
        this.trinhdohv = sht1.trinhdohv;
    }

    @Override
    public void nhap() {
        super.nhap();
        linhvuc = in.nextLine();
        trinhdohv = in.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-25s%s\n","Linh vuc chuyen nganh:", linhvuc);
        System.out.printf("%-25s%s\n","Trinh do hoc van:", trinhdohv);
    }

}
