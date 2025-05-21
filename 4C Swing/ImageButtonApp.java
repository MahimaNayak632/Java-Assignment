/* 4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour
 Glass  is pressed” depending upon the Jbutton with image  either  Digital Clock or  Hour Glass is
 pressed by implementing the event handling mechanism with addActionListener( ) */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonApp extends JFrame implements ActionListener {

    private JLabel messageLabel;

    public ImageButtonApp() {
        setTitle("Image Button App");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Load images (place your images in project folder)
        ImageIcon clockIcon = new ImageIcon("Digital Clock.jpg");
        ImageIcon hourglassIcon = new ImageIcon("Hourglass.jpg");

        JButton digitalClockBtn = new JButton("Digital Clock", clockIcon);
        JButton hourGlassBtn = new JButton("Hour Glass", hourglassIcon);

        digitalClockBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        digitalClockBtn.setVerticalTextPosition(SwingConstants.BOTTOM);

        hourGlassBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        hourGlassBtn.setVerticalTextPosition(SwingConstants.BOTTOM);

        digitalClockBtn.addActionListener(this);
        hourGlassBtn.addActionListener(this);

        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(digitalClockBtn);
        add(hourGlassBtn);
        add(messageLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("Digital Clock".equals(command)) {
            messageLabel.setText("Digital Clock is pressed");
        } else if ("Hour Glass".equals(command)) {
            messageLabel.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ImageButtonApp();
    }
}

