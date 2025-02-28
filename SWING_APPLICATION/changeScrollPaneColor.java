import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollPanelColorChooser extends JFrame {

    private JScrollPane scrollPane;
    private JPanel contentPanel;
    private JButton chooseColorButton;

    public ScrollPanelColorChooser() {
        setTitle("Scroll Panel Color Chooser");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(600, 600));

        scrollPane = new JScrollPane(contentPanel);
        chooseColorButton = new JButton("Choose Color");

        add(scrollPane, BorderLayout.CENTER);
        add(chooseColorButton, BorderLayout.SOUTH);

        chooseColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScrollPaneColor();
            }
        });
    }

    private void changeScrollPaneColor() {
        Color selectedColor = JColorChooser.showDialog(this, "Choose Background Color", contentPanel.getBackground());
        if (selectedColor != null) {
            contentPanel.setBackground(selectedColor);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScrollPanelColorChooser app = new ScrollPanelColorChooser();
            app.setVisible(true);
        });
    }
}
