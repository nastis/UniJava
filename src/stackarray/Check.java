package stackarray;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lily
 * Date: 29.03.14
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
public class Check {
    public static void main(String[] args) {
        StackArray st = new StackArray();

        if (args.length != 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        String pathin = args[0];
        String pathout = args[1];

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
        String[] array;
        int count = -1;

        try {
            while ((str = bufi.readLine()) != null) {
                array = str.split(" ");
                if (array[0].equals("PUSH")) {
                    count++;
                    if (array.length == 1) {
                        System.out.println("Error in line " + count + ": element for PUSH command wasn't specified");
                    } else {
                        st.push(Integer.parseInt(array[1]));
                        st.print(bufo);
                        bufo.newLine();
                    }
                } else if (array[0].equals("POP")) {
                    count++;
                    int element = (Integer)st.pop();
                    bufo.write("Popped element: " + element + "\n");
                    st.print(bufo);
                    bufo.newLine();
                } else if (array[0].equals("PEEK")) {
                    count++;
                    int elem = (Integer)st.peek();
                    bufo.write("Peeked element: " + elem + "\n");
                } else if (array[0].equals("SIZE")) {
                    count++;
                    int size = st.size();
                    bufo.write("Size is " + size + "\n");
                } else if (array[0].equals("CLEAR")) {
                    count++;
                    st.clear();
                } else if (array[0].equals("ISEMPTY")) {
                    count++;
                    if (st.isEmpty()) {
                        bufo.write("Stack is empty\n");
                    } else {
                        bufo.write("Stack is not empty\n");
                    }
                } else {
                    count++;
                    System.out.println("Wrong command " + array[0] + " in line " + count);
                }


            }
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
