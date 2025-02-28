import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ActionEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Action Event Example");
        JButton button = new JButton("My Button");
        
        frame.add(button);

        ButtonActionListener listener = new ButtonActionListener(frame);
        button.addActionListener(listener);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class ButtonActionListener implements ActionListener {
    private JFrame parentFrame;

    public ButtonActionListener(JFrame frame) {
        this.parentFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(parentFrame, e.getActionCommand() + " clicked");
    }
}
