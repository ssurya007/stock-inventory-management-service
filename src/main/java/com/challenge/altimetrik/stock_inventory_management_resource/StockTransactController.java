package com.challenge.altimetrik.stock_inventory_management_resource;

import com.challenge.altimetrik.stock_inventory_management.StockTransactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class StockTransactController {

    @Autowired
    private StockTransactService stockTransactService;

    @Autowired
    private StockTransactMapper stockItemMapper;

    @PostMapping(value = "${api.stock.create}")
    public StockCreateModifyResponse createStock(
            @RequestHeader("reqChannel") @Valid @Pattern(regexp = "IB|MB", flags = {Pattern.Flag.CASE_INSENSITIVE}) String channel,
            @RequestHeader(value = "version", defaultValue = "1.0") String version,
            @RequestHeader("transactionId") @Valid @NotBlank String transactionId,
            @RequestBody @Valid StockCreateRequest stockCreateRequest)
    {
            return stockItemMapper.mapToStockCreateModifyResponse(
                    stockTransactService.createStock(stockItemMapper.mapStockCreateRequest(stockCreateRequest)));
    }

    @GetMapping(value = "${api.stock.getByName}")
    public GetStockResponse getStockByName(
            @RequestHeader("reqChannel") @Valid @Pattern(regexp = "IB|MB", flags = {Pattern.Flag.CASE_INSENSITIVE}) String channel,
            @RequestHeader(value = "version", defaultValue = "1.0") String version,
            @RequestHeader("transactionId") @Valid @NotBlank String transactionId,
            @PathVariable("stock-name") String stockName)
    {
        return stockItemMapper.mapToGetStockResponse(
                stockTransactService.getStockByName(stockName));
    }

    @PutMapping(value = "${api.stock.update}")
    public StockCreateModifyResponse updateStock(
            @RequestHeader("reqChannel") @Valid @Pattern(regexp = "IB|MB", flags = {Pattern.Flag.CASE_INSENSITIVE}) String channel,
            @RequestHeader(value = "version", defaultValue = "1.0") String version,
            @RequestHeader("transactionId") @Valid @NotBlank String transactionId,
            @RequestBody @Valid StockUpdateRequest stockUpdateRequest)
    {
        return stockItemMapper.mapToStockCreateModifyResponse(
                stockTransactService.updateStock(stockItemMapper.mapStockUpdateRequest(stockUpdateRequest)));
    }
}
