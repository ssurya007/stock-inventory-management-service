package com.challenge.altimetrik.stock_inventory_management_resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockCreateModifyResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("errorDescription")
    private String errorDesc;
}
