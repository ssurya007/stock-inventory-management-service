package com.challenge.altimetrik.stock_inventory_management;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StockTransactServiceImplTest {

    @Mock
    private StockTransactRepository stockTransactRepository;

    @InjectMocks
    private StockTransactServiceImpl stockTransactService;

    @Test
    public void testShouldCreateStock() {
        //Given
        Stock createReq = Stock.builder().build();
        Stock createResExp = Stock.builder().build();
        when(stockTransactRepository.createStock(createReq)).thenReturn(createResExp);

        //When
        Stock createResponseActual = stockTransactService.createStock(createReq);

        //Then
        assertEquals(createResExp, createResponseActual);
    }

    @Test
    public void testShouldUpdateStock() {
        //Given
        Stock updateReq = Stock.builder().build();
        Stock updateRes = Stock.builder().build();
        when(stockTransactRepository.updateStock(updateReq)).thenReturn(updateRes);

        //When
        Stock updateResponseActual = stockTransactService.updateStock(updateReq);

        //Then
        assertEquals(updateRes, updateResponseActual);
    }

    @Test
    public void testShouldGetStock() {
        //Given
        Stock stockResExpected = Stock.builder().build();
        when(stockTransactRepository.getStockByName("stock_name")).thenReturn(stockResExpected);

        //When
        Stock stockResActual = stockTransactService.getStockByName("stock_name");

        //Then
        assertEquals(stockResExpected, stockResActual);
    }
}
