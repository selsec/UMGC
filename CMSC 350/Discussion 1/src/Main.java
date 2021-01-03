/*
 * Steve Thaw
 * CMSC 350 Week 1 Discussion
 * 23 May 2020
 * A simple program to compare the growth rates of different functions
 */

public class Main {

    public static int log2(int N) {
        //this method solves for log base 2 because Java only solves for log 10
        int answer = (int) ((int) (Math.log(N)) / (Math.log(2)));
        return answer;

    }

    public static void main(String[] args) {
        //main program logic
        int N = 0;
        int fN = 0;
        int gN = 0;

        System.out.println("Comparing growthrate of f(N) = Log2N and g(N) NLog2N: ");
        System.out.println("N       f(N)=Log2(N)        g(N) = NLog2(N)");
        while (fN >= gN) {
            N++;
            fN = log2(N) * N;
            gN = (N * log2(N)) * N;
            System.out.println(N + "        " + fN + "                      " + gN);

        }
        //continuing chart to 10
        for (int i = 3; i < 10; i++) {
            N++;
            fN = log2(N) * N;
            gN = (N * log2(N)) * N;
            System.out.println(N + "        " + fN + "                      " + gN);

        }
        System.out.println("\ng(N) overtakes f(N) when N = 3");
    }
}
