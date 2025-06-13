package bai_thi.entity;

public abstract class  DienThoai {
    private String id;
    private String ten;
    private int gia;
    private int soLuong;
    private String nhaSanXuat;

    public DienThoai() {
    }

    public DienThoai(String id, String ten, int gia, int soLuong, String nhaSanXuat) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' ;

    }
    public String getInfoToFIle(){
        return this.id+","+this.ten+","+this.gia+","+this.soLuong+","+this.nhaSanXuat;
    }
}
