package bai_thi.entity;

public class DienThoaiXachTay extends DienThoai {
    private String quocGIaXachTay;
    private String trangThai;

    public DienThoaiXachTay() {
    }

    public DienThoaiXachTay(String id, String ten, int gia, int soLuong, String nhaSanXuat, String quocGIaXachTay, String trangThai) {
        super(id, ten, gia, soLuong, nhaSanXuat);
        this.quocGIaXachTay = quocGIaXachTay;
        this.trangThai = trangThai;
    }

    public String getQuocGIaXachTay() {
        return quocGIaXachTay;
    }

    public void setQuocGIaXachTay(String quocGIaXachTay) {
        this.quocGIaXachTay = quocGIaXachTay;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "\n[Điện thoại xách tay]" +
                super.toString() +
                "\n   Quốc gia xách tay: " + quocGIaXachTay +
                "\n   Trạng thái: " + trangThai;
    }

    public String getInfoToFIle(){
        return super.getInfoToFIle()+","+this.quocGIaXachTay+","+this.trangThai+",,";
    }
}
