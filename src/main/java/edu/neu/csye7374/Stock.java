package edu.neu.csye7374;
import java.util.ArrayList;
import java.util.List;
abstract class Stock implements Tradable {
    protected String name;
    protected double price;
    protected String description;
    protected List<Double> bids;

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.bids = new ArrayList();
    }

    public void setBid(String bid) {
        try {
            double bidValue = Double.parseDouble(bid);
            this.bids.add(bidValue);
            this.price = this.calculateNewPrice(bidValue);
        } catch (NumberFormatException var4) {
            System.out.println("Invalid bid: " + bid);
        }

    }

    protected abstract double calculateNewPrice(double bid);

    public abstract String getMetric();

    public String toString() {
        return String.format("Stock{name='%s', price=%.2f, description='%s', metric='%s'}", this.name, this.price, this.description, this.getMetric());
    }
}
