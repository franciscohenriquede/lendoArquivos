package Udemy.EF220.entiites;

public class produto {
    private String name;
    private Double price;
    private Integer Quantity;
    public String getName() {
        return name;
    }
    public produto(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        Quantity = quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return Quantity;
    }
    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
public double Total(){
    return price * Quantity;
}
}
