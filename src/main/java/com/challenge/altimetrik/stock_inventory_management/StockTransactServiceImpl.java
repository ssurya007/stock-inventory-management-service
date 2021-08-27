package com.challenge.altimetrik.stock_inventory_management;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StockTransactServiceImpl implements StockTransactService {

    StockTransactRepository stockTransactRepository;

    @Override
    public Stock createStock(Stock stock){
        return stockTransactRepository.createStock(stock);
    }

    @Override
    public Stock getStockByName(String stockName) {
        return stockTransactRepository.getStockByName(stockName);
    }

    @Override
    public Stock updateStock(Stock stock) {
        return stockTransactRepository.updateStock(stock);
    }
}
