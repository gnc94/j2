import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SelectionEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Selection Event Example");
        JLabel label = new JLabel("Select an option", JLabel.CENTER);
        String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"};
        JComboBox<String> comboBox = new JComboBox<>(options);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label.setText("Selected: " + e.getItem().toString());
                }
            }
        });

        frame.setLayout(null);
        comboBox.setBounds(100, 100, 200, 30);
        label.setBounds(100, 150, 200, 30);

        frame.add(comboBox);
        frame.add(label);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
