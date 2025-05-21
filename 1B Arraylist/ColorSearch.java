import java.util.*;

public class ColorSearch {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Orange");
        colors.add("Green");
        colors.add("Pink");
        colors.add("Red");

        System.out.println(colors);

        if (colors.contains("Red")) {
            System.out.println("Available");
        } else {
            System.out.println("Not available");
        }
    }
}
