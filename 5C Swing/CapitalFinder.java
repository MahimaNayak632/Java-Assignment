/*5c. Develop a Swing program in Java to add the countries  USA,  India,  Vietnam,  Canada,  
Denmark, France,   Great Britain, Japan,   Africa, Greenland,  Singapore into a JList  and 
display the capital of the countries on console  whenever the countries are selected on the list.  */
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CapitalFinder extends JFrame {

    public CapitalFinder() {
        setTitle("Country Capital Finder");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        String[] countries = {"USA", "India", "Vietnam", "Canada", "Denmark", "France",
                              "Great Britain", "Japan", "Africa", "Greenland", "Singapore"};

        HashMap<String, String> capitals = new HashMap<>();
        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "Addis Ababa");
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        JList<String> countryList = new JList<>(countries);
        countryList.setVisibleRowCount(5);
        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(countryList);

        countryList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                java.util.List<String> selected = countryList.getSelectedValuesList();
                for (String country : selected) {
                    System.out.println("Capital of " + country + " is " + capitals.get(country));
                }
            }
        });

        add(scrollPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CapitalFinder();
    }
}

