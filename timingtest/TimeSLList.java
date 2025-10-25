package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        AList<Integer> Ns = new AList<Integer>();
        AList<Integer> op = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        int x =1000;
        for (int i = 0; i < 8; i++) { //N:1000 ~ 128000
            op.addLast(10000);
            Ns.addLast(x);

            x=x*2;
        }

        for (int i = 0; i < Ns.size(); i++) {

            SLList<Integer> testSLList = new SLList<>();
            int n = Ns.get(i);
            for (int j = 0; j < n; j++) {
                testSLList.addLast(0);
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < 10000; j++) {
                testSLList.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, op);

    }


}
