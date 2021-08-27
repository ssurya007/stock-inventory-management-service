package com.challenge.altimetrik.stock_inventory_management;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    //request properties
    private Integer stockNumber;
    private String stockName;
    private Double purchasingPrice;
    private LocalDate purchaseDate;
    private Integer quantity;

    //response properties
    private String status;
    private String errorDesc;
}
