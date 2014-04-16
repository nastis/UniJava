import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lily
 * Date: 29.03.14
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
public class Check {
    public enum Command {
        PUSH, POP, PEEK, SIZE, ISEMPTY, CLEAR
    }
    public static void main(String[] args) throws IOException {
        StackArray st = new StackArray();

        String pathin = args[0];
        String pathout = args[1];

        BufferedReader bufi = null;
        File input = new File(pathin);
        bufi = new BufferedReader(new FileReader(input));

        BufferedWriter bufo = null;
        File output = new File(pathout);
        bufo = new BufferedWriter(new FileWriter(output));




        String str;
        String[] array = new String[2];
        while ((str = bufi.readLine()) != null) {
            array = str.split(" ");
            switch (Command.valueOf(array[0])) {
                case PUSH:
                    st.push(Integer.parseInt(array[1]));
                    st.print(bufo);
                    bufo.newLine();
                    break;
                case POP:
                    int element = st.pop();
                    bufo.write("Popped element: " + element + "\n");
                    st.print(bufo);
                    bufo.newLine();
                    break;
                case PEEK:
                    int elem = st.peek();
                    bufo.write("Peeked element: " + elem + "\n");
                    break;
                case SIZE:
                    int size = st.size();
                    bufo.write("Size is " + size + "\n");
                    break;
                case CLEAR:
                    st.clear();
                case ISEMPTY:
                    if (st.isEmpty()) {
                        bufo.write("Stack is empty\n");
                    } else {
                        bufo.write("Stack is not empty\n");
                    }
                    break;
                default:
                    bufo.write("Wrong command" + array[0] + "\n");

            }
        }

        bufi.close();
        bufo.close();

    }
}
