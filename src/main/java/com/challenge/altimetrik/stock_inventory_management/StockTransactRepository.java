package com.challenge.altimetrik.stock_inventory_management;

public interface StockTransactRepository {
    Stock createStock(Stock stockRequest);
    Stock getStockByName(String stockName);
    Stock updateStock(Stock stock);
}
