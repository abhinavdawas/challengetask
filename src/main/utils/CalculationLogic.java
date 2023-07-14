package main.utils;

import main.model.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationLogic implements Taxes {

    public CalculationLogic() {
    }
   public BigDecimal getPriceWithoutTax(Item item){
        return item.getPrice().multiply(new BigDecimal(item.getQuantity()));
    }
    public BigDecimal getPriceWithTax(Item item) {
       BigDecimal tax = BigDecimal.ZERO;
        if (!item.isExempt()) {
            tax = tax.add(getPriceWithoutTax(item).multiply(taxRate));
        }
        if (item.isImported()) {
            tax = tax.add(getPriceWithoutTax(item).multiply(importDuty));
        }
        return getPriceWithoutTax(item).add(tax);
    }

    public BigDecimal roundTax(BigDecimal tax) {
        return tax.setScale(2, RoundingMode.HALF_UP);
    }

    public String toString(Item item) {
        return item.getQuantity() +  " " + (item.isImported() ? "imported " : "") + item.getName() + ": " + getPriceWithTax(item);
    }

    }

