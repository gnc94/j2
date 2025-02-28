import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Layout Example");
        GridLayout layout = new GridLayout(3, 4);
        frame.setLayout(layout);

        for (int i = 1; i <= 12; i++) {
            JButton button = new JButton("My Button " + i);
            frame.add(button);
        }

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
