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

        st.add(5);
        st.add(10);
        st.add(3);
        st.print();
        if (st.contains(11)) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
        st.remove(5);
        st.print();
        System.out.println("size:" + st.size());
        StackArray test = new StackArray(2);
        test.add(10);
        test.add(3);
        System.out.println("size:" + test.size());
        if (st.equals(test)) {
            System.out.println("equals");
        }
        else {
            System.out.println("not equals");
        }
    }
}
