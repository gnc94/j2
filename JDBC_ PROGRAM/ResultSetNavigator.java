import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ResultSetNavigator {
    private static ResultSet resultSet;
    private static JLabel idLabel, nameLabel, priceLabel;
    private static JTextField idField, nameField, priceField;
    private static JButton prevButton, nextButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ResultSet Navigator");
        idLabel = new JLabel("Product ID:");
        nameLabel = new JLabel("Product Name:");
        priceLabel = new JLabel("Price:");

        idField = new JTextField();
        nameField = new JTextField();
        priceField = new JTextField();

        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");

        idLabel.setBounds(20, 20, 100, 30);
        idField.setBounds(130, 20, 200, 30);

        nameLabel.setBounds(20, 70, 100, 30);
        nameField.setBounds(130, 70, 200, 30);

        priceLabel.setBounds(20, 120, 100, 30);
        priceField.setBounds(130, 120, 200, 30);

        prevButton.setBounds(50, 180, 100, 30);
        nextButton.setBounds(200, 180, 100, 30);

        idField.setEditable(false);
        nameField.setEditable(false);
        priceField.setEditable(false);

        frame.add(idLabel);
        frame.add(idField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(prevButton);
        frame.add(nextButton);

        frame.setLayout(null);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";
        String query = "SELECT * FROM products";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                displayCurrentRow();
            }

            prevButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (resultSet.previous()) {
                            displayCurrentRow();
                        } else {
                            JOptionPane.showMessageDialog(frame, "No previous records!");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (resultSet.next()) {
                            displayCurrentRow();
                        } else {
                            JOptionPane.showMessageDialog(frame, "No more records!");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void displayCurrentRow() {
        try {
            idField.setText(String.valueOf(resultSet.getInt("product_id")));
            nameField.setText(resultSet.getString("product_name"));
            priceField.setText(String.valueOf(resultSet.getDouble("price")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
