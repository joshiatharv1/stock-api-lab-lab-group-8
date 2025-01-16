package edu.neu.csye7374;

public class TechStock extends Stock {
    public TechStock(String name, double price, String description) {
        super(name, price, description);
    }

    protected double calculateNewPrice(double bid) {
        return this.price * 1.02 + bid * 0.01;
    }

    public String getMetric() {
        return String.format("%.2f", this.price * 1.5 - (double)this.bids.size());
    }
}
