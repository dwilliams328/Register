package cash.register;

import java.util.List;

public class ScannedItem {
    private String item;
    private int quantity;
    private double price;
    private double saleTaxAmount;
    private double importTaxAmount;


    public ScannedItem(){
        this.item = "none";
        this.quantity = 0;
        this.price = 0;
        this.saleTaxAmount = 0.0;
    }

    public ScannedItem(String item, int quantity, double price){
        this.item = item;
        this.quantity = quantity;
        this.price = price;

    }

    public String getItem() {
        return this.item;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public double getSaleTaxAmount(){
        return this.saleTaxAmount;
    }

    public void setSaleTaxAmount(double saleTaxAmount){
        this.saleTaxAmount = saleTaxAmount;
    }

    public double getImportTaxAmount(){
        return this.saleTaxAmount;
    }

    public void setImportTaxAmount(double importTaxAmount){
        this.importTaxAmount = importTaxAmount;
    }



    @Override
    public String toString(){
        String product = "Object " + this.item;

        return product;

    }
}
