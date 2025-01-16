package edu.neu.csye7374;

public class FinanceStock extends Stock{
    public FinanceStock(String name, double price, String description) {
        super(name, price, description);
    }

    protected double calculateNewPrice(double bid) {
        return this.price * 0.88 + bid * 0.06;
    }

    public String getMetric() {
        return String.format("%.2f", this.price * Math.log((double)(this.bids.size() + 1)));
    }
}
