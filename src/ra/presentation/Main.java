package ra.presentation;

import ra.business.config.InputMethods;

public class Main {
    public static void main(String[] args) {
        do {
            System.out.println("******************SHOP MENU*******************\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát\n" +
                    "Mời nhập lựa chọn");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    CategoriesManagement.categoriesManager();
                    break;
                case 2:
                    ProductManagement.productManger();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
        while (true);
    }
}