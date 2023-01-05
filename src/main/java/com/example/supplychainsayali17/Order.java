package com.example.supplychainsayali17;
import javafx.scene.chart.PieChart;
public class Order {
    public static boolean placeOrder(String costumerEmail, Product product) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String query = String.format(" INSERT INTO orders(costumer_id,product_id) VALUES ((SELECT costumer_id FROM costumer WHERE email='%s'),%s) ", costumerEmail, product.getId());
        int rowCount = 0;
        try {
            rowCount = databaseConnection.executeUpdateQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCount != 0;
    }
}
