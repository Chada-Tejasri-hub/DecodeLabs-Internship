import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Double> rates = new HashMap<>();

        // Exchange rates with INR as base
        rates.put("INR", 1.0);
        rates.put("USD", 0.012);
        rates.put("EUR", 0.011);
        rates.put("GBP", 0.0093);
        rates.put("JPY", 1.73);

        System.out.println("====================================");
        System.out.println("      CURRENCY CONVERTER");
        System.out.println("====================================");

        System.out.println("Available Currencies:");
        System.out.println("INR");
        System.out.println("USD");
        System.out.println("EUR");
        System.out.println("GBP");
        System.out.println("JPY");

        System.out.print("\nEnter Base Currency: ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter Target Currency: ");
        String target = sc.next().toUpperCase();

        if (!rates.containsKey(base) || !rates.containsKey(target)) {
            System.out.println("Invalid Currency!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        // Convert to INR first
        double amountInINR = amount / rates.get(base);

        // Convert INR to target currency
        double convertedAmount = amountInINR * rates.get(target);

        System.out.println("\n----------- RESULT -----------");
        System.out.printf("%.2f %s = %.2f %s\n",
                amount, base, convertedAmount, target);

        sc.close();
    }
}