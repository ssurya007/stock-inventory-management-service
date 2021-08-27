package com.challenge.altimetrik.stock_inventory_management_adapter;

import com.challenge.altimetrik.stock_inventory_management.Stock;
import lombok.AllArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StockMapper {
    private DozerBeanMapper dozerBeanMapper;

    public StockEntity mapStockToEntity(Stock stock) {
        StockEntity stockEntity = new StockEntity();
        dozerBeanMapper.map(stock, stockEntity);
        return stockEntity;
    }

    public Stock mapEntityToStock(StockEntity stockEntity) {
        Stock stock = new Stock();
        dozerBeanMapper.map(stockEntity, stock);
        return stock;
    }

}
