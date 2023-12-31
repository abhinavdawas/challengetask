package main.model;

import java.math.BigDecimal;

public class Item {

    private int quantity;
    private String name;
    private BigDecimal price;
    private boolean isImported;
    private boolean isExempt;

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public void setExempt(boolean exempt) {
        isExempt = exempt;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public Item() {
    }

    public Item(int quantity, String name, BigDecimal price, boolean isImported, boolean isExempt) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }
}
