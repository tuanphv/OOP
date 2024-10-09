package PHAT;
public class Phieuphat {
    private String Mapp;
    private String Madg;
    private String Tongphat;
    public Phieuphat(){}
    public Phieuphat(String mapp, String madg, String tongphat) {
        this.Mapp = mapp;
        this.Madg = madg;
        this.Tongphat = tongphat;
    }
    public Phieuphat(Phieuphat s1) {
        this.Mapp = s1.Mapp;
        this.Madg = s1.Madg;
        this.Tongphat = s1.Tongphat;
    }
    public String getMapp(){return Mapp;}
    public String getMadg(){return Madg;}
    public String getTongphat(){return Tongphat;}
    public void setMapp(){this.Mapp=Mapp;}
    public void setMadg(){this.Madg=Madg;}
    public void setTongphat(){this.Tongphat=Tongphat;}
}
