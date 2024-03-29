package ra.business.entity;

import ra.business.config.InputMethods;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static ra.business.implement.CategoriesImplement.listCategories;
import static ra.business.implement.ProductImplement.listProduct;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private LocalDate created;
    private int catalogId;

    private Status productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, LocalDate created, int catalogId, Status productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public Status getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Status productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData() {
        this.productId = inputProductId();
        this.productName = inputProductName();
        this.price=inputProductPrice();
        this.description=inputProductDescription();
        this.created=inputProductCreate();
        this.catalogId=inputCatalogId();
        this.productStatus=inputProductStatus();
    }

    public String inputProductId() {
        String regex = "^[CSA]{1}[0-9]{3}$";
        do {
            System.out.println("Nhập mã sản phẩm:");
            String inputId = InputMethods.getString();
            if (inputId.matches(regex)) {
                boolean isExist = false;
                for (int i = 0; i < listProduct.size(); i++) {
                    if (listProduct.get(i).getProductId().equals(inputId)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Mã danh mục đã tồn tại, mời nhập lại.");
                } else {
                    return inputId;
                }
            } else {
                System.err.println("Mã sản phẩm phải đúng định dạng C/S/A___");
            }
        }
        while (true);
    }

    public String inputProductName() {
        do {
            System.out.println("Nhập tên cho sản phẩm: ");
            String inputName = InputMethods.getString();
            if (inputName.trim().length()>=10 && inputName.trim().length()<=50){
                boolean isExist = false;
                for (int i = 0; i < listProduct.size(); i++) {
                    if (listProduct.get(i).getProductName().equals(inputName)){
                        isExist = true;
                        break;
                    }
                }
                if (isExist){
                    System.err.println("Tên sản phẩm đã tồn tại, mời nhập lại.");
                } else {
                    return inputName;
                }
            } else {
                System.err
                        .println("Độ dài tên phải nằm trong khoảng 10-50 ký ");
            }
        }
        while (true);
    }
    public float inputProductPrice(){
        do {
            System.out.println("Nhập giá cho sản phẩm: ");
            float inputPrice = InputMethods.getFloat();
            if (inputPrice>0){
                return inputPrice;
            } else {
                System.err.println("Giá sản phẩm phải lớn hơn 0, mời nhập lại.");
            }
        } while (true);
    }
    public String inputProductDescription(){
        System.out.println("Nhập mô tả:");
        String inputDescription = InputMethods.getString();
        return inputDescription;
    }
    public LocalDate inputProductCreate(){
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";
        do {
            System.out.println("Nhập ngày nhập sản phẩm: ");
            String inputLocalDate = InputMethods.getString();
            if (inputLocalDate.matches(regex)){
                return LocalDate.parse(inputLocalDate,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } else {
                System.err.println("Ngày tháng không đúng định dạng (dd/MM/yyyy)");
            }

        }while (true);

    }
    public int inputCatalogId(){
        do {
            if (!listCategories.isEmpty()){
                System.out.println("Nhập mã danh mục cho sản phẩm: ");
                for (int i = 0; i < listCategories.size(); i++) {
                    System.out.printf("%d. Mã danh mục: %-5d || Tên danh mục: %-10s\n",(i+1),listCategories.get(i).getCatalogId(),listCategories.get(i).getCatalogName());
                    System.out.println("======================================================");
                }
                int inputCatalogId = InputMethods.getInteger();
                boolean isChose = false;
                for (int i = 0; i < listCategories.size(); i++) {
                    if (listCategories.get(i).getCatalogId()==inputCatalogId){
                        isChose = true;
                        return inputCatalogId;
                    }
                }
                if (!isChose){
                    System.err.println("Mã danh mục nhận vào không đúng, mời nhập lại.");
                }
            }
         else{
                System.err.println("Danh mục trống, hãy thêm mới danh mục");
             return 0;}
        }
        while (true);
    }
    public Status inputProductStatus(){
        do {
            System.out.println("Nhập trạng thái cho sản phẩm(Active/Block/Inactive:");
            String inputStatus = InputMethods.getString();
            if (inputStatus.toUpperCase().equals("ACTIVE")){
                return Status.ACTIVE;
            } else if (inputStatus.toUpperCase().equals("INACTIVE")) {
                return Status.INACTIVE;
            } else if (inputStatus.toUpperCase().equals("BLOCK")) {
                return Status.BLOCK;
            } else {
                System.err.println("Trạng thái nhập vào không đúng, mời nhập lại.");
            }
        }
        while (true);
    }
    public void displayData(){
        System.out.printf("Mã sản phẩm: %-5s || Tên sản phẩm %-13s || Giá: %-10f\n",this.productId,this.productName,this.price);
        System.out.printf("Mô tả: %-25s\n",this.description);
        System.out.printf("Ngày nhập: %-10s || Mã danh mục: %-3d || Trạng thái: %-8s\n",
                this.created.toString(),this.catalogId,this.productStatus.getName());
        System.out.println("=================================================\n");
    }
}
