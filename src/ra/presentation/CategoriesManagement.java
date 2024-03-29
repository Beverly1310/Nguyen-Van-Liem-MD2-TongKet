package ra.presentation;

import ra.business.config.InputMethods;
import ra.business.design.ICategories;
import ra.business.implement.CategoriesImplement;

public class CategoriesManagement {
    public static ICategories categories = new CategoriesImplement();
    public static void categoriesManager() {
        boolean isExit = false;
        do {
            System.out.println("********************CATEGORIES MENU***********\n" +
                    "1. Nhập thông tin các danh mục\n" +
                    "2. Hiển thị thông tin các danh mục\n" +
                    "3. Cập nhật thông tin danh mục\n" +
                    "4. Xóa danh mục\n" +
                    "5. Cập nhật trạng thái danh mục\n" +
                    "6. Quay lại\n" +
                    "Mời nhập lựa chọn:");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    categories.createData();
                    break;
                case 2:
                    categories.displayAll();
                    break;
                case 3:
                    categories.updateData();
                    break;
                case 4:
                    categories.deleteData();
                    break;
                case 5:
                    categories.changeStatus();
                    break;
                case 6:
                    isExit = true;
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        } while (!isExit);
    }
}
