import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flow Layout Example");
        FlowLayout layout = new FlowLayout();
        frame.setLayout(layout);

        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton("My Button " + i);
            frame.add(button);
        }

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
