import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            // Input sales data
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter sales data (enter 'end' to finish):");

            BufferedWriter writer = new BufferedWriter(new FileWriter("daily_sales.txt"));

            String input;
            Set<String> productsSold = new HashSet<>();
            int totalSales = 0;

            while (!(input = reader.readLine()).equalsIgnoreCase("end")) {
                String[] parts = input.split(",");
                if (parts.length != 2) {
                    System.out.println("Invalid input format. Please enter product name and amount separated by a comma.");
                    continue;
                }
                String productName = parts[0].trim();
                int amount;
                try {
                    amount = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Please enter a valid number.");
                    continue;
                }

                writer.write(String.format("Product: " + productName + " Sold: " + amount));

                productsSold.add(productName);
                totalSales += amount;
            }

            writer.close();

            // Generate report
            System.out.println("Writing data to daily_sales.txt...");

            System.out.println("Generating report...");
            System.out.println("Total Sales: $" + totalSales);
            System.out.println("Unique Products Sold: " + productsSold.size());

            // Read and process sales data from the file
            reader = new BufferedReader(new FileReader("daily_sales.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line (e.g., extract product name and amount sold)
                // ...
            }
            reader.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}