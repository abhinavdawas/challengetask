package main;

import main.model.Item;
import main.utils.CalculationLogic;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int numItems = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Item[] items = new Item[numItems];
        CalculationLogic calculationLogic = new CalculationLogic(items);

        for (int i = 0; i < numItems; i++) {
            System.out.print("Enter item " + (i + 1) + " name: ");
            String name = scanner.nextLine();

            System.out.print("Enter item " + (i + 1) + " price: ");
            BigDecimal price = scanner.nextBigDecimal();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Is item " + (i + 1) + " imported? (true/false): ");
            boolean isImported = scanner.nextBoolean();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Is item " + (i + 1) + " exempt? (true/false): ");
            boolean isExempt = scanner.nextBoolean();
            scanner.nextLine(); // Consume the newline character

            items[i] = new Item(name, price, isImported, isExempt);
        }

        scanner.close();

        BigDecimal totalSalesTaxes = BigDecimal.ZERO;
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (Item item : items) {
            totalSalesTaxes = totalSalesTaxes.add(calculationLogic.getPriceWithTax(item).subtract(calculationLogic.getPrice(item)));
            totalAmount = totalAmount.add(calculationLogic.getPriceWithTax(item));
            System.out.println(calculationLogic.toString(item));
        }

        System.out.println("Sales Taxes: " + totalSalesTaxes);
        System.out.println("Total: " + totalAmount);
    }
}
