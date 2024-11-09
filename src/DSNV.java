import java.util.Arrays;

public class DSNV {
    NhanVien []dsnv= new NhanVien[0];
    
    private void them_mang(){
        int solg= dsnv.length;
        dsnv= Arrays.copyOf(dsnv, solg+ 1);
    }

    private void bo_mang(){
        int solg= dsnv.length;
        dsnv= Arrays.copyOf(dsnv, solg+ 1);
    }

    public void them(int n){
        int solg= dsnv.length;
        for (int i=0; i< solg; i++){
            them_mang();
            dsnv[i]= new NhanVien();
            dsnv[i].nhap();
            if (!ktraMaNV(dsnv[i].getMaNV())){
                System.out.print("Da co ma so nhan vien trong danh sach");
                bo_mang();
            }
        }
    }

    public void xoa(String n){
        int solg= dsnv.length;
        for(int i=0; i< solg; i++)
            if(dsnv[i].getMaNV().equals(n)){
                for(int j=i; j< solg; j++)
                    dsnv[i].copyNV(dsnv[i+1]);
                return;
            }
        System.out.println("Khong co ma nhan vien trong danh sach");
    }

    public boolean ktraMaNV(String n){
        int solg= dsnv.length;
        for (int i=0; i< solg; i++)
            if (dsnv[i].getMaNV().equals(n))
                return false;
        return true;
    }
}
