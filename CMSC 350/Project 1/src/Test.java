import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input: ");
        String input = s.nextLine();
        Evaluator testing = new Evaluator();
        testing.postToPre(input);
    }
}
