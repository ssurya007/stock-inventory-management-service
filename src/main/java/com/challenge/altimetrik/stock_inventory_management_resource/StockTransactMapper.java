package com.challenge.altimetrik.stock_inventory_management_resource;

import com.challenge.altimetrik.stock_inventory_management.Stock;
import lombok.AllArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StockTransactMapper {
    private DozerBeanMapper dozerBeanMapper;

    public Stock mapStockCreateRequest(StockCreateRequest stockCreateRequest) {
        Stock stock = new Stock();
        dozerBeanMapper.map(stockCreateRequest, stock);
        return stock;
    }

    public Stock mapStockUpdateRequest(StockUpdateRequest stockUpdateRequest) {
        Stock stock = new Stock();
        dozerBeanMapper.map(stockUpdateRequest, stock);
        return stock;
    }

    public StockCreateModifyResponse mapToStockCreateModifyResponse(Stock stock) {
        StockCreateModifyResponse stockCreateModifyResponse = new StockCreateModifyResponse();
        dozerBeanMapper.map(stock, stockCreateModifyResponse);
        return stockCreateModifyResponse;
    }


    public GetStockResponse mapToGetStockResponse(Stock stock) {
        GetStockResponse getStockResponse = new GetStockResponse();
        dozerBeanMapper.map(stock, getStockResponse);
        return getStockResponse;
    }
}
