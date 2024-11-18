package models;

public class Product {
    private int id;
    private String name;
    private String priceForSmth;
    private double price;
    private double count;
    private int categoryID;


    public Product(double count, int id, String name, double price, String priceForSmth) {
        this.count = count;
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceForSmth = priceForSmth;
    }

    public Product() {
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceForSmth() {
        return priceForSmth;
    }

    public void setPriceForSmth(String priceForSmth) {
        this.priceForSmth = priceForSmth;
    }

    @Override
    public String toString() {
        return "Product{" +
                "count=" + count +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", priceForSmth='" + priceForSmth + '\'' +
                ", price=" + price +
                '}';
    }
}
