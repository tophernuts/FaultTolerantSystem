package test;

import com.hut.HeapSort;
import com.hut.Sort;
import junit.framework.TestCase;
import org.junit.Before;

import java.util.Random;

public class HeapSortTest extends TestCase {

    private Sort sort;

    @Before
    public void setUp(){
        sort = new HeapSort();
    }

    public void testSortOneValue(){
        int[] a = {0};
        sort.setValues(a);
        sort.sort();

        // XXX: Should I even be checking the length?
        assertEquals(a.length, 1);
        assertEquals(a[0], 0);
    }

    public void testSortArrayEmpty() {
        int[] a = {};
        sort.setValues(a);
        sort.sort();

        assertEquals(a.length, 0);
    }

    public void testSortAllSameValue(){
        int[] a = {1,1,1,1,1};
        sort.setValues(a);
        sort.sort();

        assertEquals(a.length, 5);
        for(int i: a){
            assertEquals(i, 1);
        }
        checkSorted(a);
    }

    public void testAlreadySorted(){
        int a[] = {4, 8, 15, 16, 23, 42};
        sort.setValues(a);
        sort.sort();

        checkSorted(a);
    }

    public void testReverseSorted(){
        int a[] = {108, 42, 23, 16, 15, 8, 4};
        sort.setValues(a);
        sort.sort();

        checkSorted(a);
    }

    public void testEvenNumberRandomElements(){
        Random r = new Random();
        int a[] = new int[100];
        for(int i = 0; i < 100; i++){
            a[i] = r.nextInt();
        }

        sort.setValues(a);
        sort.sort();

        checkSorted(a);
    }

    public void testOddNumberRandomElements(){
        Random r = new Random();
        int a[] = new int[101];
        for(int i = 0; i < 101; i++){
            a[i] = r.nextInt();
        }

        sort.setValues(a);
        sort.sort();

        checkSorted(a);
    }

    public void testMiddleValuesEqual(){
        int a[] = {4, 8, 15, 15, 23, 42};
        sort.setValues(a);
        sort.sort();

        checkSorted(a);
    }

   private void checkSorted(int[] a){
       int prev = a[0];
       for(int i = 1; i < a.length-1; i++){
           if(prev > a[i]){
               assertTrue(String.format("A[%d]: %d, A[%d]: %d", i, a[i], i-1, a[i-1]), prev <= a[i]);
           }
           prev = a[i];
       }
   }

    private void debugPrint(int[]a){
        StringBuilder sb = new StringBuilder();
        if(a.length == 0) System.out.println("Array was 0 length");
        for(int i : a){
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}