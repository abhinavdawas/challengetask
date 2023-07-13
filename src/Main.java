import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Item {
    private String name;
    private BigDecimal price;
    private boolean isImported;
    private boolean isExempt;

    public Item(String name, BigDecimal price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceWithTax() {
        BigDecimal tax = BigDecimal.ZERO;
        if (!isExempt) {
            tax = tax.add(price.multiply(new BigDecimal("0.10")));
        }
        if (isImported) {
            tax = tax.add(price.multiply(new BigDecimal("0.05")));
        }
        return price.add(roundTax(tax));
    }

    private BigDecimal roundTax(BigDecimal tax) {
        BigDecimal roundedTax = tax.divide(new BigDecimal("0.05"), 0, RoundingMode.UP)
                .multiply(new BigDecimal("0.05"));
        return roundedTax.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "1 " + name + ": " + getPriceWithTax();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int numItems = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Item[] items = new Item[numItems];

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
            totalSalesTaxes = totalSalesTaxes.add(item.getPriceWithTax().subtract(item.getPrice()));
            totalAmount = totalAmount.add(item.getPriceWithTax());
            System.out.println(item.toString());
        }

        System.out.println("Sales Taxes: " + totalSalesTaxes);
        System.out.println("Total: " + totalAmount);
    }
}
