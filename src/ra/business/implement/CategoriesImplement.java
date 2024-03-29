package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.ICategories;
import ra.business.entity.Categories;

import java.util.ArrayList;
import java.util.List;

import static ra.business.implement.ProductImplement.listProduct;

public class CategoriesImplement implements ICategories {
    public static List<Categories> listCategories = new ArrayList<>();

    @Override
    public int findIndexById() {
        System.out.println("Nhập Id danh mục:");
        int inputId = InputMethods.getInteger();
        for (int i = 0; i < listCategories.size(); i++) {
            if (listCategories.get(i).getCatalogId() == inputId) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void createData() {
        System.out.println("Nhập số danh mục muốn thêm mới");
        int count = InputMethods.getInteger();
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập thông thin cho danh mục thứ " + i);
            Categories newCategories = new Categories();
            newCategories.inputData();
            listCategories.add(newCategories);
        }
    }

    @Override
    public void displayAll() {
        listCategories.forEach(Categories::displayData);
    }

    @Override
    public void updateData() {
        displayAll();
        int updateIndex = findIndexById();
        if (updateIndex != -1) {
            listCategories.get(updateIndex).displayData();
            listCategories.get(updateIndex).setCatalogName("");
            listCategories.get(updateIndex).inputData();
        } else {
            System.err.println("Danh mục không tồn ");
        }
    }

    @Override
    public void deleteData() {
        displayAll();
        int deleteIndex = findIndexById();
        if (deleteIndex != -1) {
            boolean isContain = false;
            for (int i = 0; i < listProduct.size(); i++) {
                if (listCategories.get(deleteIndex).getCatalogId() == listProduct.get(i).getCatalogId()) {
                    System.err.println("Danh mục vẫn còn sản phẩm, không thể xóa");
                    isContain = true;
                    break;
                }
            }
            if (!isContain) {
                listCategories.remove(deleteIndex);
            }
        } else {
            System.err.println("Danh mục không tồn ");
        }
    }

    @Override
    public void changeStatus() {
        displayAll();
        int indexCategories = findIndexById();
        if (indexCategories != -1) {
            listCategories.get(indexCategories).setCatalogStatus(!listCategories.get(indexCategories).isCatalogStatus());
        } else {
            System.err.println("Danh mục không tồn tại");
        }
    }
}
