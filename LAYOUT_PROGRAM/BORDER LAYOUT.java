import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Border Layout Example");
        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        JButton nButton = new JButton("North");
        JButton sButton = new JButton("South");
        JButton wButton = new JButton("West");
        JButton eButton = new JButton("East");
        JButton cButton = new JButton("Center");

        frame.add(nButton, BorderLayout.NORTH);
        frame.add(sButton, BorderLayout.SOUTH);
        frame.add(wButton, BorderLayout.WEST);
        frame.add(eButton, BorderLayout.EAST);
        frame.add(cButton, BorderLayout.CENTER);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
