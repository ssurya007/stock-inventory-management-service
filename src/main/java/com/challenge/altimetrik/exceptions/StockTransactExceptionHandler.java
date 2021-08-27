package com.challenge.altimetrik.exceptions;

import com.challenge.altimetrik.common.Constants;
import com.challenge.altimetrik.stock_inventory_management_resource.StockCreateModifyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class StockTransactExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<StockCreateModifyResponse> handleBusinessException(BusinessException e, WebRequest request) {
        return ResponseEntity.badRequest().body(buildResponseBody(e.getMessage()));
    }

    @ExceptionHandler(value = {DuplicateResourceException.class})
    public ResponseEntity<StockCreateModifyResponse> handleDuplicateResourceException(DuplicateResourceException e, WebRequest webRequest) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildResponseBody(Constants.RESOURCE_ALREADY_EXISTS_MSG));
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<StockCreateModifyResponse> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildResponseBody(Constants.RESOURCE_NOT_FOUND_MSG));
    }

    @ExceptionHandler(value = {UnexpectedException.class})
    public ResponseEntity<StockCreateModifyResponse> handleUnexpectedException(UnexpectedException e, WebRequest request) {
        return ResponseEntity.internalServerError().body(buildResponseBody(Constants.UNEXPECTED_ERROR_MSG));
    }

    private StockCreateModifyResponse buildResponseBody(String msg) {
        StockCreateModifyResponse stockCreateModifyResponse = new StockCreateModifyResponse();
        stockCreateModifyResponse.setStatus(Constants.STATUS_FAILURE);
        stockCreateModifyResponse.setErrorDesc(msg);
        return stockCreateModifyResponse;
    }
}
