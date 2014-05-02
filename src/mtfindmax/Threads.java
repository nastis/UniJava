package mtfindmax;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lily
 * Date: 02.05.14
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class Threads implements Runnable {

    private List finalList;
    private int[] array;

    public Threads(int[] array, List finalList) {
        this.array = array;
        this.finalList = finalList;
    }

    @Override
    public void run() {
//        System.out.println("\nHello from thread " + Thread.currentThread().getId());
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        finalList.add(max);

    }

}
