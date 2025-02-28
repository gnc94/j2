import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Focus Event Example");
        JTextField textField1 = new JTextField("Enter text here...");
        JTextField textField2 = new JTextField("Another text field");
        JLabel label = new JLabel("Focus on a text field", JLabel.CENTER);

        textField1.setBounds(50, 50, 200, 30);
        textField2.setBounds(50, 100, 200, 30);
        label.setBounds(50, 150, 300, 30);

        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                label.setText("Focus gained on: " + ((JTextField) e.getSource()).getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                label.setText("Focus lost from: " + ((JTextField) e.getSource()).getText());
            }
        };

        textField1.addFocusListener(focusListener);
        textField2.addFocusListener(focusListener);

        frame.add(textField1);
        frame.add(textField2);
        frame.add(label);

        frame.setLayout(null);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
