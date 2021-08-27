package com.challenge.altimetrik.stock_inventory_management_adapter;

import com.challenge.altimetrik.common.Constants;
import com.challenge.altimetrik.exceptions.DuplicateResourceException;
import com.challenge.altimetrik.exceptions.ResourceNotFoundException;
import com.challenge.altimetrik.exceptions.UnexpectedException;
import com.challenge.altimetrik.stock_inventory_management.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.UnexpectedRollbackException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StockTransactRepositoryAdapterTest {

    @Mock
    private StockTransactJpaRepository stockTransactJpaRepository;
    @Mock
    private StockMapper stockMapper;

    @InjectMocks
    private StockTransactRepositoryAdapter stockTransactRepositoryAdapter;

    @Test
    public void testShouldCreateStockWithGivenInput() {
        //Given
        Stock stock = Stock.builder().build();
        StockEntity stockEntity = new StockEntity();
        when(stockMapper.mapStockToEntity(stock)).thenReturn(stockEntity);
        when(stockTransactJpaRepository.save(stockEntity)).thenReturn(stockEntity);

        //When
        Stock stockResponse = stockTransactRepositoryAdapter.createStock(stock);

        //Then
        assertEquals(Constants.CREATION_SUCCESS_MSG, stockResponse.getStatus());
    }

    @Test(expected = DuplicateResourceException.class)
    public void testShouldHandleExceptionInStockCreation() {
        //Given
        Stock stock = Stock.builder().build();
        StockEntity stockEntity = new StockEntity();
        when(stockMapper.mapStockToEntity(stock)).thenReturn(stockEntity);
        when(stockTransactJpaRepository.save(stockEntity)).thenThrow(DataIntegrityViolationException.class);

        //When
        Stock stockResponse = stockTransactRepositoryAdapter.createStock(stock);

    }

    @Test(expected = UnexpectedException.class)
    public void testShouldHandleUnExpectedExceptionInStockCreation() {
        //Given
        Stock stock = Stock.builder().build();
        StockEntity stockEntity = new StockEntity();
        when(stockMapper.mapStockToEntity(stock)).thenReturn(stockEntity);
        when(stockTransactJpaRepository.save(stockEntity)).thenThrow(UnexpectedRollbackException.class);

        //When
        Stock stockResponse = stockTransactRepositoryAdapter.createStock(stock);

    }

    @Test
    public void testShouldGetStockByName() {
        //Given
        Stock stock = Stock.builder().build();
        StockEntity stockEntity = new StockEntity();
        when(stockTransactJpaRepository.findByStockName("stock_name")).thenReturn(stockEntity);
        when(stockMapper.mapEntityToStock(stockEntity)).thenReturn(stock);

        //When
        Stock stockResponse = stockTransactRepositoryAdapter.getStockByName("stock_name");

        //Then
        assertEquals(stock, stockResponse);
    }

    @Test(expected = UnexpectedException.class)
    public void testShouldHandleUnExpectedExceptionInGettingStock() {
        //Given
        Stock stock = Stock.builder().build();
        when(stockTransactJpaRepository.findByStockName("stock_name")).thenThrow(UnexpectedRollbackException.class);

        //When
        Stock stockResponse = stockTransactRepositoryAdapter.getStockByName("stock_name");
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testShouldThrowExceptionWhenNoDataFound() {
        //Given
        Stock stock = Stock.builder().build();
        when(stockTransactJpaRepository.findByStockName("stock_name")).thenReturn(null);

        //When
        Stock stockResponse = stockTransactRepositoryAdapter.getStockByName("stock_name");
    }

    @Test
    public void testShouldUpdateStockWithGivenValues() {
        //Given
        Stock stock = buildStock();
        StockEntity stockEntity = new StockEntity();
        when(stockTransactJpaRepository.updateStock(100.0,LocalDate.parse("2021-08-28"),100,1)).thenReturn(1);

        //When
        Stock stockResponse = stockTransactRepositoryAdapter.updateStock(stock);

        //Then
        assertEquals(Constants.UPDATE_SUCCESS_MSG, stockResponse.getStatus());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testShouldThrowExceptionIfUpdateStockFailed() {
        //Given
        Stock stock = buildStock();
        StockEntity stockEntity = new StockEntity();
        when(stockTransactJpaRepository.updateStock(100.0,LocalDate.parse("2021-08-28"),100,1)).thenReturn(0);

        //When
        Stock stockResponse = stockTransactRepositoryAdapter.updateStock(stock);
    }

    @Test(expected = UnexpectedException.class)
    public void testShouldHandleExceptionInUpdateStockTransaction() {
        //Given
        Stock stock = buildStock();
        StockEntity stockEntity = new StockEntity();
        when(stockTransactJpaRepository.updateStock(100.0, LocalDate.parse("2021-08-28"),100,1))
                .thenThrow(UnexpectedRollbackException.class);

        //When
        Stock stockResponse = stockTransactRepositoryAdapter.updateStock(stock);
    }

    private Stock buildStock() {
        return Stock.builder().stockName("Apple")
                .purchaseDate(LocalDate.parse("2021-08-28"))
                .purchasingPrice(100.0)
                .stockNumber(1)
                .quantity(100)
                .build();
    }

}
