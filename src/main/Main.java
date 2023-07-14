package main;

import main.model.Basket;
import main.model.Item;

import main.utils.Receipt;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int numItems = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Basket basket = new Basket();

        for (int i = 0; i < numItems; i++) {

            System.out.print("Enter item " + (i + 1) + " quantity: ");
             int quantity = scanner.nextInt();
              scanner.nextLine(); // Consume the newline character

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

            Item item = new Item(quantity,name, price, isImported, isExempt);
            basket.addItem(item);
        }
        scanner.close();

        // Generate and print the receipt
        Receipt receipt = new Receipt(basket);
        receipt.printReceipt();
    }
}
