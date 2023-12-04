import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {
    private static final String API_KEY = "YOUR_API_KEY"; // Replace with your API key
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            URL url = new URL(API_URL + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse JSON response
                String jsonResponse = response.toString();
                double rate = parseExchangeRate(jsonResponse, targetCurrency);
                if (rate != -1) {
                    return rate;
                }
            } else {
                System.out.println("Error: Unable to fetch exchange rates. HTTP response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private double parseExchangeRate(String jsonResponse, String targetCurrency) {
        // Implement your JSON parsing logic here
        // Extract the exchange rate for the target currency from the JSON response
        // Return -1 if parsing fails
        // Example: Parse the JSON response using a JSON library like Jackson or Gson
        return -1;
    }

    public double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate != -1) {
            return amount * exchangeRate;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        double convertedAmount = converter.convertCurrency(amount, baseCurrency, targetCurrency);

        if (convertedAmount != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Error converting currency. Please try again.");
        }

        scanner.close();
    }
}
