package ra.business.entity;

public enum Status {
    ACTIVE("Đang bán"),
    BLOCK("Hết hàng"),
    INACTIVE("Không bán");
    private final String name;


    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
