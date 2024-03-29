package ra.business.implement;

import ra.business.config.InputMethods;
import ra.business.design.IProduct;
import ra.business.entity.Categories;
import ra.business.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductImplement implements IProduct {
    public static List<Product> listProduct = new ArrayList<>();

    // thêm mới sản phẩm
    @Override
    public void createData() {
        System.out.println("Nhập số sản phẩm muốn thêm mới");
        int count = InputMethods.getInteger();
        for (int i = 1; i <= count; i++) {
            System.out.println("Nhập thông tin cho sản phẩm thứ " + i);
            Product newProduct = new Product();
            newProduct.inputData();
            listProduct.add(newProduct);
        }
    }

    //hiển thị danh sách sản phẩm
    @Override
    public void displayAll() {
        listProduct.forEach(Product::displayData);
    }

    // cập nhật sản phẩm
    @Override
    public void updateData() {
        displayAll();
        int updateIndex = findIndexById();
        if (updateIndex != -1) {
            listProduct.get(updateIndex).displayData();
            listProduct.get(updateIndex).setProductId("");
            listProduct.get(updateIndex).setProductName("");
            listProduct.get(updateIndex).inputData();
        } else {
            System.err.println("Sản phẩm không tồn ");
        }
    }

    // xóa sản phẩm
    @Override
    public void deleteData() {
        displayAll();
        int deleteIndex = findIndexById();
        if (deleteIndex != -1) {
            listProduct.remove(deleteIndex);
        } else {
            System.err.println("Sản phẩm không tồn ");
        }
    }

    // trả về index qua Id
    @Override
    public int findIndexById() {
        System.out.println("Nhập ID sản phẩm:");
        String inputId = InputMethods.getString();
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductId().equals(inputId)) {
                return i;
            }
        }
        return -1;
    }

    // sắp xếp theo giá giảm dần
    @Override
    public void sortByPrice() {
        Collections.sort(listProduct, (o1, o2) -> {
            return (int) (o2.getPrice() - o1.getPrice());
        });
        displayAll();
    }

    // tìm thông qua tên
    @Override
    public void findByName() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String inputName = InputMethods.getString();
        if (listProduct.stream().filter(product -> product.getProductName().equals(inputName)).count() > 0) {
            listProduct.stream().filter(product -> product.getProductName().equals(inputName)).forEach(Product::displayData);
        } else {
            System.err.println("Không có sản phẩm nào");
        }
    }

    // tìm sản phẩm trong khoảng
    @Override
    public void findWithin() {
        System.out.println("Nhập giá tối thiểu:");
        float fromPrice = InputMethods.getFloat();
        System.out.println("Nhập giá tối đa:");
        float toPrice = InputMethods.getFloat();
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getPrice() >= fromPrice && listProduct.get(i).getPrice() <= toPrice) {
                listProduct.get(i).displayData();
            }
        }
    }
}
