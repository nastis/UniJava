
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lily
 * Date: 15.03.14
 * Time: 0:13
 * To change this template use File | Settings | File Templates.
 */
public class StackArray extends AbstractCollection<Integer> {

    private static final int DEFAULT_SIZE = 10;
    Integer[] stack;
    Integer top = -1;
    //constructor


    public StackArray() {
        stack = new Integer[DEFAULT_SIZE];
    }

    public StackArray(int initSize) {
        stack = new Integer[initSize];
    }

    @Override
    public boolean add(Integer integer) {
        if (integer==null){
            throw new NullPointerException("value cannot be null");
        }
        if (top == stack.length - 1) {
            stack=Arrays.copyOf(stack,stack.length*2);
        }
        top++;
        stack[top] = integer;
        return true;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) throw new NullPointerException("value cannot be null");
        if (!(o instanceof Integer)) throw new ClassCastException("wrong type");
        Integer val = (Integer) o;
        for (int i = 0; i <= top; i++) {
            if (val.equals(stack[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        StackArray st = (StackArray) o;
        Integer[] array = new Integer[st.size()];
        st.toArray(array);
        if (array.length == top + 1) {
            int i = 0;
            while ((stack[i].equals(array[i])) && (i <= top)){
                i++;
            }
            if (i == top + 1){
                return true;
            }
        }

        //  if (array.length != top + 1) return false;
        //  for (int i = 0; i <= top; i++) {
//            if (!(stack[i].equals(array[i]))){
//                return false;
//            }
//        }

//        return true;

        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Integer)) return false;
        int val = (Integer) o;
        int i = 0;
        while ((!stack[i].equals(val)) && (i <= top))
            i++;
        if (i == top)
            return false;
        top--;
        return true;
        //TODO WRONG
    }

    @Override
    public void clear() {
        top = -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)){
                return false;
            }
        }
        return true;
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
        MyIterator iterator = new MyIterator();
        return iterator;
    }

    private class MyIterator implements Iterator<Integer> {
        private int cursor = -1;

        boolean check = false;

        @Override
        public boolean hasNext() {
            if (cursor == top) {
                return false;
            }
            return true;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                check = true;
                cursor++;
                return stack[cursor];

            }
            throw new NoSuchElementException("there is no such element");
        }

        @Override
        public void remove() {
            if (cursor == -1) {
                throw new IllegalStateException("iterator is before the first element");
            }
            if (!check) {
                throw new IllegalStateException("You cannot remove twice");
            }
            check = false;
            StackArray.this.remove(stack[cursor]);
            cursor--;
        }
    }




}
