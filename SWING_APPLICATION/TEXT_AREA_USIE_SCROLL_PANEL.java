import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class ShowFileInTextArea extends JFrame {

    private final JTextArea textArea = new JTextArea(20, 40);
    private JButton OpenFileButton = new JButton("Open File");

    ShowFileInTextArea() {
        setTitle("File Views");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        add(OpenFileButton, BorderLayout.SOUTH);

        OpenFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setLineWrap(true);
                textArea.setText(content.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading this file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

public class Pratical {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShowFileInTextArea app = new ShowFileInTextArea();
            app.setVisible(true);
        });
    }
}
