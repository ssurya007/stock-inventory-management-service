package com.challenge.altimetrik.stock_inventory_management_adapter;

import com.challenge.altimetrik.common.Constants;
import com.challenge.altimetrik.exceptions.DuplicateResourceException;
import com.challenge.altimetrik.exceptions.ResourceNotFoundException;
import com.challenge.altimetrik.exceptions.UnexpectedException;
import com.challenge.altimetrik.stock_inventory_management.Stock;
import com.challenge.altimetrik.stock_inventory_management.StockTransactRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.UnexpectedRollbackException;

import java.util.Objects;


@Component
@AllArgsConstructor
@Slf4j
public class StockTransactRepositoryAdapter implements StockTransactRepository {

    private final StockTransactJpaRepository stockTransactJpaRepository;
    private final StockMapper stockMapper;

    @Override
    public Stock createStock(Stock stock) {
        try {
            stockTransactJpaRepository.save(stockMapper.mapStockToEntity(stock));
            return Stock.builder().status(Constants.CREATION_SUCCESS_MSG).build();
        } catch (DataIntegrityViolationException exception) {
            throw new DuplicateResourceException(exception);
        } catch(Exception exception) {
            throw new UnexpectedException(exception);
        }
    }

    @Override
    public Stock getStockByName(String stockName) {
        StockEntity stockEntity = null;
        try {
            stockEntity = stockTransactJpaRepository.findByStockName(stockName);
        } catch (Exception e) {
            throw new UnexpectedException(e);
        }
        if(Objects.nonNull(stockEntity)) {
            return stockMapper.mapEntityToStock(stockEntity);
        }
        throw new ResourceNotFoundException();
    }

    @Override
    public Stock updateStock(Stock stock) {
        try {
            int updateCount = stockTransactJpaRepository.updateStock(stock.getPurchasingPrice(), stock.getPurchaseDate(), stock.getQuantity(), stock.getStockNumber());
            if(updateCount == 1)
                return Stock.builder().status(Constants.UPDATE_SUCCESS_MSG).build();
            throw new ResourceNotFoundException();
        } catch(UnexpectedRollbackException exception) {
            throw new UnexpectedException(exception);
        }
    }

}
