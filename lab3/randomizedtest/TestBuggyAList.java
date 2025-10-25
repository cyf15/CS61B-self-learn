package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE//
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    //  @Test
//  public void testAList() {
//      AListNoResizing<Integer> L = new AListNoResizing<>();
//        int N = 500;
//        for (int i = 0; i < N; i += 1) {
//            int operationNumber = StdRandom.uniform(0, 3);
//            if (operationNumber == 0) {
//                // addLast
//                int randVal = StdRandom.uniform(0, 100);
//                L.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
//            }
//
//            else if (operationNumber == 1) {
//                // size
//                int size = L.size();
//                System.out.println("size: " + size);
//            }
//        }
//    }
//}
    @Test
    public void testAandB() {
        AListNoResizing<Integer> good = new AListNoResizing<>();
        BuggyAList<Integer> bad = new BuggyAList<>();
        int N = 50;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0,4 );
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                good.addLast(randVal);
                bad.addLast(randVal);
                System.out.println("A addLast(" + randVal + ")");
                System.out.println("B addLast(" + randVal + ")");

            } else if (operationNumber == 2) {
                if (good.size() > 0) {
                    int a = good.getLast();
                    int b = bad.getLast();
                    System.out.println("A getLast(" + a + ")");
                    System.out.println("B getLast(" + b + ")");
                    if(a==b){System.out.println("true");}
                    else{System.out.println("false");}
                }
            } else if (operationNumber == 3) {
                if (good.size() > 0) {
                   int a = good.removeLast();
                   int b = bad.removeLast();
                    System.out.println("A removeLast(" + a + ")");
                    System.out.println("A removeLast(" + b + ")");
                    if(a==b){System.out.println("true");}
                    else{System.out.println("false");}
                }
            } else if (operationNumber == 1) {
                // size
                int sizeA = good.size();
                int sizeB = bad.size();
                System.out.println("A size: " + sizeA);
                System.out.println("B size: " + sizeB);
            }
        }
    }

}