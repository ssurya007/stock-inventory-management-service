package com.challenge.altimetrik.config;

import org.dozer.DozerConverter;

import java.time.LocalDate;


public class DozerDateConvertor extends DozerConverter<LocalDate, LocalDate>
{
    public DozerDateConvertor() {
        super(LocalDate.class, LocalDate.class);
    }

    @Override
    public LocalDate convertTo(LocalDate dateA, LocalDate dateB) {
        return dateA;
    }

    @Override
    public LocalDate convertFrom(LocalDate dateB, LocalDate dateA) {
        return dateB;
    }
}