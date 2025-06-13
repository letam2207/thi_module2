package bai_thi.view;

import bai_thi.entity.DienThoai;
import bai_thi.entity.DienThoaiChinhHang;
import bai_thi.entity.DienThoaiXachTay;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bai_thi.service.DienThoaiXachTayService.isIdExist;

public class DienThoaiView {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayDienThoai(List<DienThoai> dienThoais){
        for (int i = 0; i < dienThoais.size(); i++) {
            System.out.println(dienThoais.get(i));
        }
    }
    public static DienThoaiXachTay addDienThoaiXachTay(){
        String id;
        String idRegex = "^XT-[0-9]{2}$";
        Pattern pattern = Pattern.compile(idRegex);
        do {
            System.out.println("Nhập ID (Định dạng 'XT-XX' X là số 0-9): ");
            id = scanner.nextLine();
            Matcher matcher = pattern.matcher(id);
            if (!matcher.matches()) {
                System.out.println(" Sai định dạng, nhập lại.");
                continue;
            }
            if (isIdExist(id)) {
                System.out.println(" ID đã tồn tại, vui lòng nhập ID khác.");
            } else {
                break;
            }
        } while (true);
        System.out.println("Nhập tên điện thoại :");
        String ten = scanner.nextLine();
        System.out.println("Nhập giá bán điện thoại :");
        int gia = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng :");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất :");
        String sanXuat = scanner.nextLine();
        System.out.println("Nhập quốc gia xách tay :");
        String quocGia = scanner.nextLine();
        System.out.println("Nhập trạn thái :");
        String trangThai = scanner.nextLine();
        return new DienThoaiXachTay(id,ten,gia,soLuong,sanXuat,quocGia,trangThai);
    }
    public static DienThoaiChinhHang addDienThoaiChinhHang(){
        String id;
        String idRegex = "^CH-[0-9]{2}$";
        Pattern pattern = Pattern.compile(idRegex);
        do {
            System.out.println("Nhập ID (Định dạng 'CH-XX' X là số 0-9): ");
            id = scanner.nextLine();
            Matcher matcher = pattern.matcher(id);
            if (!matcher.matches()) {
                System.out.println(" Sai định dạng, nhập lại.");
                continue;
            }
            if (isIdExist(id)) {
                System.out.println(" ID đã tồn tại, vui lòng nhập ID khác.");
            } else {
                break;
            }
        } while (true);
        System.out.println("Nhập tên điện thoại :");
        String ten = scanner.nextLine();
        System.out.println("Nhập giá bán điện thoại :");
        int gia = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng :");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất :");
        String sanXuat = scanner.nextLine();
        System.out.println("Nhập thời gian bảo hành :");
        int baoHanh =Integer.parseInt(scanner.nextLine()) ;
        System.out.println("Nhập trạn thái :");
        String phamVi = scanner.nextLine();
        return new DienThoaiChinhHang(id,ten,gia,soLuong,sanXuat,baoHanh,phamVi);
    }
    public static String deleteDienThoai() {
        System.out.println("Nhập ID cần xóa: ");
        String id = scanner.nextLine();
        return id;
    }
    public static String searchDienThoai() {
        System.out.println("Nhập tên điện thoại: ");
        String name = scanner.nextLine();
        return name;
    }
}
