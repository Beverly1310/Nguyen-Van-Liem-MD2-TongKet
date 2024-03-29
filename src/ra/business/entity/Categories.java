package ra.business.entity;

import ra.business.config.InputMethods;

import static ra.business.implement.CategoriesImplement.listCategories;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
        this.catalogId = autoIncreaseId();
    }

    public Categories(String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = autoIncreaseId();
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    // phương thức nhập dữ liệu
    public void inputData() {
        this.catalogName = inputCategoriesName();
        this.descriptions = inputCategoriesDescription();
        this.catalogStatus = inputCategoriesStatus();
    }

    // phương thức tự động tăng Id
    private int autoIncreaseId() {
        int maxId = 0;
        for (int i = 0; i < listCategories.size(); i++) {
            if (listCategories.get(i).getCatalogId() > maxId) {
                maxId = listCategories.get(i).getCatalogId();
            }
        }
        return maxId + 1;
    }

    // lấy tên
    public String inputCategoriesName() {
        do {
            System.out.println("Nhập tên cho danh mục:");
            String inputName = InputMethods.getString();
            boolean isExisit = false;
            for (int i = 0; i < listCategories.size(); i++) {
                if (listCategories.get(i).getCatalogName().equals(inputName)) {
                    isExisit = true;
                    break;
                }
            }
            if (isExisit) {
                System.err.println("Tên danh mục đã tồn tại, mời nhập lại.");
            } else {
                return inputName;
            }
        }
        while (true);
    }

    //lấy mô tả
    public String inputCategoriesDescription() {
        System.out.println("Mời nhập mô tả cho danh mục:");
        String inputDescription = InputMethods.getString();
        return inputDescription;
    }

    // lấy trạng thái
    public boolean inputCategoriesStatus() {
        System.out.println("Nhập trạng thái cho danh mục:");
        boolean inputStatus = InputMethods.getBoolean();
        return inputStatus;
    }

    // hiển thị thông tin
    public void displayData() {
        System.out.printf("Mã danh mục: %-5d || Tên danh mục: %-15s\n", this.catalogId, this.catalogName);
        System.out.printf("Mô tả: %-20s\n", this.descriptions);
        System.out.printf("Trạng thái: %-10s\n", this.catalogStatus ? "Hoạt động" : "Không hoạt động");
        System.out.printf("===============================\n");
    }
}
