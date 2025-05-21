/* 5a. Develop a Swing program in Java to add the countries  USA,  India,  Vietnam,  Canada,
 Denmark, France,   Great Britain, Japan,   Africa, Greenland,  Singapore into a JList  and
 display them on console  whenever the countries are selected on the list. */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountrySelector extends JFrame {

    public CountrySelector() {
        setTitle("Country Selector");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        String[] countries = {"USA", "India", "Vietnam", "Canada", "Denmark", "France",
                              "Great Britain", "Japan", "Africa", "Greenland", "Singapore"};

        JList<String> countryList = new JList<>(countries);
        countryList.setVisibleRowCount(5);
        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(countryList);

        countryList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                java.util.List<String> selected = countryList.getSelectedValuesList();
                for (String country : selected) {
                    System.out.println("Selected: " + country);
                }
            }
        });

        add(scrollPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CountrySelector();
    }
}
