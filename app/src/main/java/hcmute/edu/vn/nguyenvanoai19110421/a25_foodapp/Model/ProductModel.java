package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model;

public class ProductModel {
    private int Id;
    private String Ten;
    private String MoTa;
    private String Gia;
    private byte[] Hinh;

    public ProductModel(int id, String ten, String moTa, String gia, byte[] hinh) {
        Id = id;
        Ten = ten;
        MoTa = moTa;
        Gia = gia;
        Hinh = hinh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] hinh) {
        Hinh = hinh;
    }
    public ProductModel() {

    }
}
