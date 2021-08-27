package com.challenge.altimetrik.stock_inventory_management;

public interface StockTransactService {
    Stock createStock(Stock stock);
    Stock getStockByName(String stockName);
    Stock updateStock(Stock stock);

}
