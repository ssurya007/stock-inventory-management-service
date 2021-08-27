package com.challenge.altimetrik.config;

import com.challenge.altimetrik.stock_inventory_management.Stock;
import com.challenge.altimetrik.stock_inventory_management_adapter.StockEntity;
import com.challenge.altimetrik.stock_inventory_management_resource.StockCreateRequest;
import com.challenge.altimetrik.stock_inventory_management_resource.StockUpdateRequest;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class DozerConfig {
    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setCustomConverters(Collections.<CustomConverter> singletonList(new DozerDateConvertor()));
        BeanMappingBuilder dateConversionBuilder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Stock.class, StockEntity.class).fields("purchaseDate", "purchaseDate", FieldsMappingOptions.customConverter(DozerDateConvertor.class));
            }
        };

        BeanMappingBuilder dateConversionBuilder1 = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(StockCreateRequest.class, Stock.class).fields("purchaseDate", "purchaseDate", FieldsMappingOptions.customConverter(DozerDateConvertor.class));
            }
        };

        BeanMappingBuilder dateConversionBuilder2 = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(StockUpdateRequest.class, Stock.class).fields("purchaseDate", "purchaseDate", FieldsMappingOptions.customConverter(DozerDateConvertor.class));
            }
        };
        mapper.addMapping(dateConversionBuilder);
        mapper.addMapping(dateConversionBuilder1);
        mapper.addMapping(dateConversionBuilder2);
        return mapper;
    }
}
