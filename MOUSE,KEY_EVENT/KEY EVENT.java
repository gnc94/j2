import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class KeyEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Event Example");

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JOptionPane.showMessageDialog(frame, "Key Typed: " + e.getKeyChar());
            }
        });

        frame.setSize(450, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
