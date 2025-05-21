/**2.b. Develop a Java program to make a Performance Test on StringBuffer and StringBuilder for
appending the string ‘AIET’ for 10000 times both in the StringBuffer and StringBuilder. Justify
your answer which one is better.*/
public class Stringperformanacetest {
    public static void main(String[] args) {
        int times = 10000;
        String text = "AIET";

        // Testing StringBuffer
        StringBuffer sbuffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < times; i++) {
            sbuffer.append(text);
        }
        long endBuffer = System.nanoTime();
        long durationBuffer = endBuffer - startBuffer;
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " ns");

        // Testing StringBuilder
        StringBuilder sbuilder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < times; i++) {
            sbuilder.append(text);
        }
        long endBuilder = System.nanoTime();
        long durationBuilder = endBuilder - startBuilder;
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " ns");

        // Justification
        if (durationBuilder < durationBuffer) {
            System.out.println("Conclusion: StringBuilder is faster than StringBuffer.");
        } else {
            System.out.println("Conclusion: StringBuffer is faster than StringBuilder.");
        }
    }
}
