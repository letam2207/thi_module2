package bai_thi.entity;

public class DienThoaiChinhHang extends DienThoai {
    private int thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang() {
    }

    public DienThoaiChinhHang(String id, String ten, int gia, int soLuong, String nhaSanXuat, int thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, ten, gia, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return "\n[Điện thoại chính hãng]" +
                super.toString() +
                "\n   Thời gian bảo hành: " + thoiGianBaoHanh + " tháng" +
                "\n   Phạm vi bảo hành: " + phamViBaoHanh;
    }

    public String getInfoToFIle(){
        return super.getInfoToFIle()+","+this.thoiGianBaoHanh+","+this.phamViBaoHanh;
    }

}
