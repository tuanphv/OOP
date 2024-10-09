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
}
