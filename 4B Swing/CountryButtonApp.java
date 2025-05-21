/* 4b. Develop a Swing program in Java to display a message “Srilanka is pressed” or “India is
 pressed” depending upon the Jbutton either  Srilanka or India is pressed by implementing the
 event handling mechanism with addActionListener( ). */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountryButtonApp extends JFrame implements ActionListener {

    private JLabel messageLabel;

    public CountryButtonApp() {
        setTitle("Country Button App");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton srilankaBtn = new JButton("Srilanka");
        JButton indiaBtn = new JButton("India");

        srilankaBtn.addActionListener(this);
        indiaBtn.addActionListener(this);

        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(srilankaBtn);
        add(indiaBtn);
        add(messageLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("Srilanka".equals(command)) {
            messageLabel.setText("Srilanka is pressed");
        } else if ("India".equals(command)) {
            messageLabel.setText("India is pressed");
        }
    }

    public static void main(String[] args) {
        new CountryButtonApp();
    }
}
