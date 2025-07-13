package MarketShopApp;

import java.time.LocalDate;

public class Product {
    private String name;
    private String company;
    private double costPrice;
    private double sellingPrice;
    private int quantity;
    private LocalDate expiryDate;

    public Product(String name, String company, double costPrice, double sellingPrice, int quantity, LocalDate expiryDate) {
        this.name = name;
        this.company = company;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }
    public String getCompany() {
        return company;
    }
    public double getCostPrice() {
        return costPrice;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Product{" +
                ", name='"        +name+'\''+
                ", company='"     +company+'\''+
                ", Price="        +sellingPrice+
                ", quantity="     +quantity+
                ", expiryDate="   +expiryDate+'}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;

        Product product = (Product) obj;
        return name.equalsIgnoreCase(product.name) && company.equalsIgnoreCase(product.company);
    }
    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode() + company.toLowerCase().hashCode();
    }

}
