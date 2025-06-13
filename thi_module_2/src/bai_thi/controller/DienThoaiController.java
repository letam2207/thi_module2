package bai_thi.controller;

import bai_thi.entity.DienThoai;
import bai_thi.service.DienThoaiXachTayService;
import bai_thi.view.DienThoaiView;
import java.util.List;
import java.util.Scanner;

public class DienThoaiController {
    public static DienThoaiXachTayService dienThoaiXachTayService = new DienThoaiXachTayService();
    static Scanner scanner = new Scanner(System.in);
    public static void displayDienThoai() {
        boolean running = true;
        while (running) {
            try {
                System.out.println("-------CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI--------" +
                        "\n 1. Thêm mới " +
                        "\n 2. Xóa" +
                        "\n 3. Xem danh sách điện thoại" +
                        "\n 4. Tìm kiếm" +
                        "\n 5. Kết thúc chương trình !");
                System.out.print("Chọn chức năng: ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        addMenu();
                        break;
                    case 2:
                        delete();
                        break;
                    case 3:
                        List<DienThoai> dienThoais = dienThoaiXachTayService.findAll();
                        DienThoaiView.displayDienThoai(dienThoais);
                        break;
                    case 4:
                        search();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Chương trình kết thúc.");
                        break;
                    default:
                        System.out.println("Nhập sai lựa chọn, vui lòng nhập lại!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng! Vui lòng nhập số.");
            }
        }
    }


    public static void addMenu() {

        boolean check = true;
        do {
            try {
                System.out.println("--------CHỨC NĂNG THÊM MỚI----------");
                System.out.println("1. Thêm mới điện thoại xách tay");
                System.out.println("2. Thêm mới điện thoại chính hãng");
                System.out.println("3. Thoát");
                System.out.println("Nhập lựa chọn : ");
                int choose = Integer.parseInt(scanner.nextLine());


                switch (choose) {
                    case 1:
                        addDienthoaiXachTay();
                        break;
                    case 2:
                        addDienThoaiChinhHang();
                        break;
                    case 3:
                        check = false;
                        break;
                    default:
                        System.out.println("Nhập sai nhập lại !");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng !");
            }

        } while (check);

    }



    private static void addDienthoaiXachTay(){
        dienThoaiXachTayService.add(DienThoaiView.addDienThoaiXachTay());
        System.out.println("thêm mới thành công");
    }
    private static void addDienThoaiChinhHang(){
        dienThoaiXachTayService.add(DienThoaiView.addDienThoaiChinhHang());
        System.out.println("thêm mới thành công");
    }
    private static void delete() {
        String id = DienThoaiView.deleteDienThoai();

        if (!dienThoaiXachTayService.isIdExist(id)) {
            System.out.println("Không tìm thấy ID điện thoại");
            return;
        }
        DienThoai dienThoai = dienThoaiXachTayService.findById(id);
        System.out.println(" Thông tin sản phẩm sẽ bị xóa:");
        System.out.println(dienThoai);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bạn có chắc chắn muốn xóa sản phẩm này? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y") || confirm.equals("yes")) {
            boolean check = dienThoaiXachTayService.delete(id);
            if (check) {
                System.out.println(" Xóa thành công sản phẩm có ID: " + id);
            } else {
                System.out.println(" Xảy ra lỗi khi xóa.");
            }
        } else {
            System.out.println(" Đã hủy thao tác xóa.");
        }
    }
    private static void search(){
        List<DienThoai> dienThoais = dienThoaiXachTayService.findBYName(DienThoaiView.searchDienThoai());
        DienThoaiView.displayDienThoai(dienThoais);
    }
}
