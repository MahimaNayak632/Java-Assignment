/*5d.  Develop a Swing program in Java to create a  Tabbed Pan of Cyan, Magenta and Yellow and 
display the concerned color  whenever the specific tab is selected in the Pan */
import javax.swing.*;
import java.awt.*;

public class CMYTabbedPane extends JFrame {

    public CMYTabbedPane() {
        setTitle("CMY Tabs");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);

        add(tabbedPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CMYTabbedPane();
    }
}

