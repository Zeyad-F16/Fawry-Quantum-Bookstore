package models;

public class Paper extends Book {

    private int quantity;

    public Paper(String ISBN, String title, int publishYear, double price, int quantity , boolean isDemo) {
        super(ISBN, title, publishYear, price , isDemo);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

}
