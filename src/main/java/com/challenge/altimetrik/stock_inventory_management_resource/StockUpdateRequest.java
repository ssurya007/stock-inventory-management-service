package com.challenge.altimetrik.stock_inventory_management_resource;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class StockUpdateRequest {
    @NotNull
    private Integer stockNumber;
    @NotNull
    private Double purchasingPrice;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;
    @NotNull
    private Integer quantity;
}
