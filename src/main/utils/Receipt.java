package main.utils;

import main.model.Basket;
import main.model.Item;

import java.math.BigDecimal;

public class Receipt extends CalculationLogic  {

    private Basket basket;

    public Receipt(Basket basket) {
        this.basket = basket;
    }

    public void printReceipt(){
        BigDecimal totalSalesTaxes = BigDecimal.ZERO;
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (Item item : basket.getItems()) {
            totalSalesTaxes = totalSalesTaxes.add(super.getPriceWithTax(item).subtract(super.getPriceWithoutTax(item)));
            totalAmount = totalAmount.add(super.getPriceWithTax(item));
            System.out.println(super.toString(item));
        }

        totalSalesTaxes = super.roundTax(totalSalesTaxes);
        totalAmount = super.roundTax(totalAmount);

        System.out.println("Sales Taxes: " + totalSalesTaxes);
        System.out.println("Total: " + totalAmount);
    }
    }


