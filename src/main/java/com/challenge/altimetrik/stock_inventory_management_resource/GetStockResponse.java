package com.challenge.altimetrik.stock_inventory_management_resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetStockResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("errorDescription")
    private String errorDesc;

    @JsonProperty("stockNumber")
    private Integer stockNumber;
    @JsonProperty("stockName")
    private String stockName;
    @JsonProperty("purchasingPrice")
    private Double purchasingPrice;
    @JsonProperty("purchaseDate")
    private String purchaseDate;
    @JsonProperty("quantity")
    private Integer quantity;
}
