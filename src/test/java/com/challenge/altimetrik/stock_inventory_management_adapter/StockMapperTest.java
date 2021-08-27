package com.challenge.altimetrik.stock_inventory_management_adapter;

import com.challenge.altimetrik.config.DozerDateConvertor;
import com.challenge.altimetrik.stock_inventory_management.Stock;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StockMapper.class, DozerBeanMapper.class, DozerDateConvertor.class})
public class StockMapperTest {

    @Autowired
    private StockMapper stockMapper;

    @Test
    public void testMapToEntity() {
        //Given
        Stock stock = buildStock();

        //When
        StockEntity stockEntity = stockMapper.mapStockToEntity(stock);

        //Then
        assertEquals(stock.getPurchaseDate(), stockEntity.getPurchaseDate());
        assertEquals(stock.getPurchasingPrice(), stockEntity.getPurchasingPrice());
        assertEquals(stock.getQuantity(), stockEntity.getQuantity());
        assertEquals(stock.getStockNumber(), stockEntity.getStockNumber());
        assertEquals(stock.getStockName(), stockEntity.getStockName());

    }

    @Test
    public void testMapEntityToStock() {
        //Given
        StockEntity stockEntity = buildStockEntity();

        //When
        Stock stock = stockMapper.mapEntityToStock(stockEntity);

        //Then
        assertEquals(stockEntity.getPurchaseDate(), stock.getPurchaseDate());
        assertEquals(stockEntity.getPurchasingPrice(), stock.getPurchasingPrice());
        assertEquals(stockEntity.getQuantity(), stock.getQuantity());
        assertEquals(stockEntity.getStockNumber(), stock.getStockNumber());
        assertEquals(stockEntity.getStockName(), stock.getStockName());

    }

    private Stock buildStock() {
        return Stock.builder().stockName("Apple")
                .purchasingPrice(100.0)
                .stockNumber(1)
                .quantity(100)
                .build();
    }

    private StockEntity buildStockEntity() {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setPurchasingPrice(1000.0);
        stockEntity.setStockName("Apple");
        stockEntity.setQuantity(100);
        stockEntity.setStockNumber(1);
        return stockEntity;
    }
}
