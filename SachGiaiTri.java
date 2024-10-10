public class SachGiaiTri extends Sach{
    private int dotuoi;

    public SachGiaiTri() {}

    public SachGiaiTri(String masach, String tensach, String manxb, String matg, int namxb, int dongia, int soluong, String theloai, String tinhtrang, int dotuoi)
    {
        super(masach, tensach, manxb, matg, namxb, dongia, soluong, theloai, tinhtrang);
        this.dotuoi = dotuoi;
    }

    public SachGiaiTri(SachGiaiTri sgt1) 
    {
        super((Sach) sgt1);
        this.dotuoi = sgt1.dotuoi;
    }

    @Override
    public void nhap() {
        super.nhap();
        dotuoi = Integer.parseInt(in.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-25s%d\n","Do tuoi phu hop:", dotuoi);
    }

}
