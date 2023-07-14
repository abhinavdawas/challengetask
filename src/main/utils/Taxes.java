package main.utils;

import main.model.Item;

import java.math.BigDecimal;

public interface Taxes {
    BigDecimal taxRate = new BigDecimal("0.10");
    BigDecimal importDuty = new BigDecimal("0.05");

    BigDecimal getPriceWithoutTax(Item item);
    BigDecimal getPriceWithTax(Item item);


}
