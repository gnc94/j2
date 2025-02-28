import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ProductDetailsViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Product Details Viewer");
        JLabel label = new JLabel("Select Product:");
        JComboBox<String> comboBox = new JComboBox<>();
        JTextArea productDetails = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(productDetails);

        label.setBounds(20, 20, 100, 30);
        comboBox.setBounds(140, 20, 200, 30);
        scrollPane.setBounds(20, 70, 400, 200);

        frame.add(label);
        frame.add(comboBox);
        frame.add(scrollPane);

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";
        String query = "SELECT product_name FROM products";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Populate the combo box with product names
            while (rs.next()) {
                comboBox.addItem(rs.getString("product_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = (String) comboBox.getSelectedItem();
                if (selectedProduct != null) {
                    String detailsQuery = "SELECT * FROM products WHERE product_name = ?";
                    try (Connection conn = DriverManager.getConnection(url, username, password);
                         PreparedStatement pstmt = conn.prepareStatement(detailsQuery)) {
                        pstmt.setString(1, selectedProduct);
                        ResultSet rs = pstmt.executeQuery();

                        // Display product details
                        if (rs.next()) {
                            StringBuilder details = new StringBuilder();
                            details.append("Product ID: ").append(rs.getInt("product_id")).append("\n");
                            details.append("Name: ").append(rs.getString("product_name")).append("\n");
                            details.append("Price: ").append(rs.getDouble("price")).append("\n");
                            details.append("Quantity: ").append(rs.getInt("quantity")).append("\n");
                            productDetails.setText(details.toString());
                        } else {
                            productDetails.setText("No details found for the selected product.");
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        frame.setLayout(null);
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
