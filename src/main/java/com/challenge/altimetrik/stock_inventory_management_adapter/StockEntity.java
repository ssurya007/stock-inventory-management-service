package com.challenge.altimetrik.stock_inventory_management_adapter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "STOCK")
@Getter
@Setter
@NoArgsConstructor
public class StockEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "STOCK_NUMBER")
    private Integer stockNumber;
    @Column(name = "STOCK_NAME", unique = true, nullable = false, updatable = false)
    private String stockName;
    @Column(name = "PURCHASING_PRICE", nullable = false)
    private Double purchasingPrice;
    @Column(name = "PURCHASE_DATE", nullable = false)
    private LocalDate purchaseDate;
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;
}