package ra.presentation;

import ra.business.config.InputMethods;
import ra.business.design.IProduct;
import ra.business.implement.ProductImplement;

public class ProductManagement {
    public static IProduct product = new ProductImplement();
    public static void productManger(){
        boolean isExit = false;
        do {
            System.out.println("*******************PRODUCT MANAGEMENT*****************\n" +
                    "1. Nhập thông tin các sản phẩm\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp các sản phẩm theo giá\n" +
                    "4. Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                    "5. Xóa sản phẩm theo mã sản phẩm\n" +
                    "6. Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
                    "7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn\n" +
                    "phím)\n" +
                    "8. Quay lại\n" +
                    "Mời nhập lựa chọn:");
            int choice = InputMethods.getInteger();
            switch (choice){
                case 1:
                    product.createData();
                    break;
                case 2:
                    product.displayAll();
                    break;
                case 3:
                    product.sortByPrice();
                    break;
                case 4:
                    product.updateData();
                    break;
                case 5:
                    product.deleteData();
                    break;
                case 6:
                    product.findByName();
                    break;
                case 7:
                    product.findWithin();
                    break;
                case 8:
                    isExit = true;
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }

        } while (!isExit);
    }
}
