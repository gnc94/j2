import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class MouseEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Event Example");
        JLabel label = new JLabel("Hello", JLabel.CENTER);
        
        label.setFont(new Font("Arial", Font.ITALIC, 20));
        frame.add(label);

        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse exited at: " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entered at: " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse released at: " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse pressed at: " + e.getX() + ", " + e.getY());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked. Button: " + e.getButton());
            }
        });

        frame.setSize(500, 500);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
