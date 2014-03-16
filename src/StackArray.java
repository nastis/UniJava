
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Lily
 * Date: 15.03.14
 * Time: 0:13
 * To change this template use File | Settings | File Templates.
 */
public class StackArray implements Collection<Integer> {

    int count = 100000;
    Integer[] stack = new Integer[count];
    Integer top = -1;
    //constructor

    @Override
    public boolean add(Integer integer) {
        if (top >= count) {
            return false;
            //increase stack sizeand return true
        }
        top++;
        stack[top] = integer;
        return true;
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }


    public boolean contains(Object o) {
        if (!(o instanceof Integer)) throw new ClassCastException("wrong type");
        Integer val = (Integer)o;
        for (int i = 0; i <= top; i++) {
            if (val.equals(stack[i]))
                return true;
        }
        return false;
    }


    @Override
    public <T> T[] toArray(T[] arr) {
        if (arr.length > top) throw new NullPointerException();
        for (int i = 0; i <= top; i++) {
            arr[i] = stack[i];
        }
        return arr;
        //extends abstract collection
    }

    public boolean equals(Object o) {
        StackArray st = (StackArray) o;
        int[] array = new int[st.size()];
        st.toArray(array);
        int[] arrst = new int[top];
        for (int i = 0; i <= top; i++) {
            arrst[i] = stack[i];
        }
        if (array.length == top) {
            int i = 0;
            while ((arrst[i] == array[i]) && (i <= top))
                i++;
            if (i == top)
                return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Integer)) return false;
        int val = (Integer)o;
        int i = 0;
        while ((stack[i] != val) && (i <= top))
            i++;
        if (i == top)
            return false;
        top--;
        return true;
    }

    @Override
    public void clear() {
        top = -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o: c) {
        //check if contains
        }




    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterator<Integer> iterator() {
       //return MyIt object
    }

    private class MyIterator implements Iterator<Integer>

    @Override
    public Object[] toArray() {
        //extends abstract
        AbstractCollection
    }



}
