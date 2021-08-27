package com.challenge.altimetrik.stock_inventory_management_adapter;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface StockTransactJpaRepository extends CrudRepository<StockEntity, Integer> {
    StockEntity findByStockName(String stockName);

    @Modifying
    @Transactional
    @Query("update StockEntity s set s.purchasingPrice = ?1 , s.purchaseDate = ?2 , s.quantity = ?3 where s.stockNumber = ?4")
    int updateStock(double purchasingPrice, LocalDate purchaseDate, int quantity, int stockNumber);
}
