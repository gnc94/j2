import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class JDBCGUITableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JDBC Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            String query = "SELECT * FROM your_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
