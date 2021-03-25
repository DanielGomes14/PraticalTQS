package tqs.ua;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {
    private String name;
    private List<Stock> stocks ;
    private IStocksMarket iStocksMarket;

    public StocksPortfolio(IStocksMarket iStocksMarket){
        this.iStocksMarket = iStocksMarket;
        this.stocks = new ArrayList<>();
    }

    public IStocksMarket getiStocksMarket() {
        return iStocksMarket;
    }

    public void setiStocksMarket(IStocksMarket iStocksMarket) {
        this.iStocksMarket = iStocksMarket;
    }

    public  void  addStock(Stock stock){
        stocks.add(stock);
    }

    public double getTotalValue(){
        double value = 0.0;
        for( Stock stock : stocks){
            value += stock.getQuantity() * iStocksMarket.getPrice(stock.getName());
        }
        return  value;
    }


}
