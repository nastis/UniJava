package stackarray;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lily
 * Date: 17.04.14
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public class StackArrayTest {
    @Test
    public void testSize() throws Exception {
        StackArray st = new StackArray();
        assertEquals(0, st.size());
        st.push(1);
        st.push(1);
        st.push(2);
        st.push(3);
        st.pop();
        st.push(5);
        assertEquals(4, st.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        StackArray st = new StackArray();
        assertEquals(true, st.isEmpty());
        st.push(1);
        st.push(1);
        st.pop();
        assertEquals(false, st.isEmpty());
    }

    @Test
    public void testClear() throws Exception {
        StackArray st = new StackArray();
        st.clear();
        assertEquals(true, st.isEmpty());
    }

    @Test
    public void testPush() throws Exception {
        StackArray st = new StackArray();
        assertTrue(st.add(1));
        assertTrue(st.add(5));
        assertEquals(2, st.size());
    }

    @Test
    public void testPop() throws Exception {
        StackArray st = new StackArray();
        st.push(1);
        st.push(1);
        st.push(2);
        assertEquals((Integer) 2, (Integer) st.pop());
        assertEquals((Integer) 1, (Integer) st.pop());
    }

    @Test
    public void testPeek() throws Exception {
        StackArray st = new StackArray();
        st.push(1);
        st.push(1);
        st.push(2);
        assertEquals(2, st.peek());
        assertEquals(3, st.size());
    }
}
