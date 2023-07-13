package main.utils;

import main.model.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationLogic {

    private Item[] items;

    public CalculationLogic(Item[] items) {
        this.items = items;
    }

    public BigDecimal getPrice(Item item) {
        return item.getPrice();
    }

    public BigDecimal getPriceWithTax(Item item) {
        BigDecimal tax = BigDecimal.ZERO;
        if (!item.isExempt()) {
            tax = tax.add(item.getPrice().multiply(new BigDecimal("0.10")));
        }
        if (item.isImported()) {
            tax = tax.add(item.getPrice().multiply(new BigDecimal("0.05")));
        }
        return item.getPrice().add(roundTax(tax));
    }

    public BigDecimal roundTax(BigDecimal tax) {
        BigDecimal roundedTax = tax.divide(new BigDecimal("0.05"), 0, RoundingMode.UP)
                .multiply(new BigDecimal("0.05"));
        return roundedTax.setScale(2, RoundingMode.HALF_UP);
    }

    public String toString(Item item) {
        return "1 " + item.getName() + ": " + getPriceWithTax(item);
    }

    }

