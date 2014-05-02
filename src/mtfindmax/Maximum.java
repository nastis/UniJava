package mtfindmax;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Lily
 * Date: 02.05.14
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class Maximum {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        String pathin = args[0];
        String threadCount = args[1];
        String pathout = "result.out";

        BufferedReader bufi = null;
        File input = new File(pathin);
        try {
            bufi = new BufferedReader(new FileReader(input));
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found. Try again, please.");
            return;
        }

        BufferedWriter bufo = null;
        File output = new File(pathout);
        try {
            bufo = new BufferedWriter(new FileWriter(output));
        } catch (IOException e) {
            System.out.println("Error: Output file not found. Try again, please.");
            try {
                bufi.close();
            } catch (IOException e1) {
                System.out.println("Error: Cannot close input buffer");
            }
            return;
        }

        String str;
        int count = 0;
        String[] arrayStr;
        int[] arrayInt;
        List<Integer> finalList = Collections.synchronizedList(new ArrayList<Integer>());

        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            while ((str = bufi.readLine()) != null) {
                count++;
                arrayStr = str.split(" ");

                arrayInt = new int[arrayStr.length];

                for (int i = 0; i < arrayStr.length; i++) {
                    arrayInt[i] = Integer.parseInt(arrayStr[i]);
                }

//                System.out.println("BEWARE DATA #" + count);
//                for (int i = 0; i < arrayInt.length; i++) {
//                    System.out.print(arrayInt[i] + " ");
//                }
//                System.out.println("\nBEWARE END OF DATA #" + count);


                Runnable thread = new Threads(arrayInt, finalList);
                executor.execute(thread);

            }
            executor.shutdown();

            while (!(executor.isTerminated())) {
            }

            int max = Integer.MIN_VALUE;

            for (int element : finalList) {
                if (element > max) {
                    max = element;
                }
            }

//            System.out.println(max);
            bufo.write(Integer.toString(max));

        } catch (IOException e) {
            System.out.println("Error in reading file");
        }

        try {
            bufi.close();
        } catch (IOException e) {
            System.out.println("Error: Cannot close input buffer");
        }
        try {
            bufo.close();
        } catch (IOException e) {
            System.out.println("Error: Cannot close output buffer");
        }


    }
}
