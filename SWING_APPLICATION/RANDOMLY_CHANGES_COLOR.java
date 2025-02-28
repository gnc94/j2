import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class ChangeColor extends JFrame {
    private JPanel colorPanel;
    private JButton changeColorButton;

    public ChangeColor() {
        setTitle("Random Color Changer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        colorPanel = new JPanel();
        changeColorButton = new JButton("Change Color");

        add(colorPanel, BorderLayout.CENTER);
        add(changeColorButton, BorderLayout.SOUTH);

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeColor();
            }
        });
    }

    private void changeColor() {
        Random random = new Random();
        Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        colorPanel.setBackground(randomColor);
    }
}

public class Pratical {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChangeColor app = new ChangeColor();
            app.setVisible(true);
        });
    }
}