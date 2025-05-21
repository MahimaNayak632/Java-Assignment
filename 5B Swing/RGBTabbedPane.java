/*5b.  Develop a Swing program in Java to create a  Tabbed Pan of RED, BLUE and GREEN and 
display the concerned color  whenever the specific tab is selected in the Pan. */
import javax.swing.*;
import java.awt.*;

public class RGBTabbedPane extends JFrame {

    public RGBTabbedPane() {
        setTitle("RGB Tabs");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);

        tabbedPane.addTab("Red", redPanel);
        tabbedPane.addTab("Blue", bluePanel);
        tabbedPane.addTab("Green", greenPanel);

        add(tabbedPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RGBTabbedPane();
    }
}

