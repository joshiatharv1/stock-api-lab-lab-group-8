package edu.neu.csye7374;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class StockMarket {
    private static StockMarket instance;
    private final Map<String, Stock> stocks = new HashMap();

    private StockMarket() {
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            Class var0 = StockMarket.class;
            synchronized(StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }

        return instance;
    }

    public void addStock(Stock stock) {
        this.stocks.put(stock.name, stock);
    }

    public void removeStock(String name) {
        this.stocks.remove(name);
    }

    public void tradeStock(String name, String bid) {
        Stock stock = (Stock)this.stocks.get(name);
        if (stock != null) {
            stock.setBid(bid);
        } else {
            System.out.println("Stock not found: " + name);
        }

    }

    public void showAllStocks() {
        Collection var10000 = this.stocks.values();
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }

    public static void demo() {
        StockMarket market = getInstance();
        Stock techStock = new TechStock("IBM", 131.15, "IBM Common Stock");
        Stock financeStock = new FinanceStock("Chase", 420.5, "Chase Finance Stock");
        market.addStock(techStock);
        market.addStock(financeStock);
        String[] bids = new String[]{"10", "20", "30", "40", "50", "60"};
        String[] var7 = bids;
        int var8 = bids.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            String bid = var7[var9];
            System.out.println("Bid: " + bid);
            market.tradeStock("IBM", bid);
            market.tradeStock("Chase", bid);
            market.showAllStocks();
            System.out.println();
        }

        market.removeStock("IBM");
        market.removeStock("Pfizer");
        System.out.println("After removing the stocks we are left with - ");
        market.showAllStocks();
    }
}
