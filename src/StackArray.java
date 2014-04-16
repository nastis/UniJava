
import java.util.*;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lily
 * Date: 15.03.14
 * Time: 0:13
 * To change this template use File | Settings | File Templates.
 */
public class StackArray extends AbstractCollection<Integer> {

    private static final int DEFAULT_SIZE = 10;
    private Integer[] stack;
    private Integer top = -1;

    /**
     * Constructor with default initial size
     */
    public StackArray() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructor with specified initial size
     */
    public StackArray(int initSize) {

        stack = new Integer[initSize];
    }

    /**
     * Add integer value to the top of the stack.
     * @param integer to be added
     * @return true; if there is not enough space, double the ize of stack
     * @throws NullPointerException
     */
    @Override
    public boolean add(Integer integer) {
        if (integer == null) {
            throw new NullPointerException("value cannot be null");
        }
        if (top == stack.length - 1) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
        top++;
        stack[top] = integer;
        return true;
    }

    /**
     * Return number of elements
     * @return number of elements in stack
     */
    @Override
    public int size() {
        return top + 1;
    }

    /**
     * Check if stack is empty
     * @return true if stack is empty; false if not
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Check if stack contains given element
     * @param o to be checked if it is contained in stack
     * @return true if o is contained in stack; false if not
     * @throws NullPointerException; ClassCastException
     */
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

    /**
     * Check if given object equals to stack
     * @param o that is to be compared to stack
     * @return true if stack and o equals; false if not
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StackArray)) return false;
        StackArray st = (StackArray) o;

        if (st.stack.length == top + 1) {
            int i = 0;
            while ((stack[i].equals(st.stack[i])) && (i < top)) {
                i++;
            }
            if ((i == top) && (this.stack[top].equals(st.stack[top]))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Remove given object from stack
     * @param o to be removed from stack
     * @return true if o was removed successfully; false if not, for example, there was not such element
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Integer)) return false;
        int val = (Integer) o;
        int i = 0;
        while ((!stack[i].equals(val)) && (i <= top)) {
            i++;
        }
        if (i == top + 1) {
            return false;
        } else {
            for (int k = i; k < top; k++) {
                stack[k] = stack[k + 1];
            }
            top--;
            return true;
        }
    }

    /**
     * Clear the stack
     */
    @Override
    public void clear() {
        top = -1;
    }

    /**
     * Check if stack contains all elements from given collection
     * @param c is a collection from where the elements are taken
     * @return true if stack contains all the elements; false if not
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Add all elements from given collection to the stack
     * @param c is a collection from where elements are taken
     * @return true if all the elements were added successfully; false if not
     */
    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer i : c) {
            if (!add(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove from the stack all the elements from given collection
     * @param c is the collection from where elements are taken
     * @return true if all the elements were removed successfully; false if not
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            if (!remove(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retain in stack those elements that are contained in given collcetion
     * @param c is the collcetion from where elements are taken
     * @return true if all redundant elements were removed successfully; false if not
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i <= top; i++) {
            if (!c.contains(stack[i])) {
                remove(stack[i]);
            }
        }
        return true;
    }

    /**
     * Create new Iterator
     * @return created Iterator
     */
    @Override
    public Iterator<Integer> iterator() {
        MyIterator iter = new MyIterator();
        return iter;
    }

    /**
     * Iterator class
     */
    private class MyIterator implements Iterator<Integer> {
        private int cursor = -1;

        private boolean check = false;

        /**
         * Ckeck if there is next element in the stack
         * @return true if there is next element; false if not
         */
        @Override
        public boolean hasNext() {
            if (cursor == top) {
                return false;
            }
            return true;
        }

        /**
         * Check if there is next element and return it
         * @return next element
         * @throws NoSuchElementException
         */
        @Override
        public Integer next() {
            if (hasNext()) {
                check = true;
                cursor++;
                return stack[cursor];

            }
            throw new NoSuchElementException("there is no such element");
        }

        /**
         * Remove element under iterator
         * @throws IllegalStateException
         */
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

    /**
     * Add element to stack
     * @param el to be added
     */
    public void push(Integer el) {
        add(el);
    }

    /**
     * Pop the top element of stack
     * @return top element of stack
     * @throws EmptyStackException
     */
    public Integer pop() {
        if (top == -1) throw new EmptyStackException();
        return stack[top--];
    }

    /**
     * Return top element but not remove it
     * @return top element of stack
     * @throws EmptyStackException
     */
    public Integer peek() {
        if (top == -1) throw new EmptyStackException();
        return stack[top];
    }

    /**
     * Print stack elements to file
     * @param buf BufferedWriter to describe the file
     * @throws IOException
     */
    public void print(BufferedWriter buf) throws IOException {
        for (int i = 0; i <= top; i++) {
            buf.write(stack[i] + "\n");
//            System.out.println(stack[i]);
        }
    }

}
