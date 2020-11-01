package ds.singly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SinglyLinkedListTest {
    private SinglyLinkedList sll;

    @Before
    public void setUp() {
        sll = new SinglyLinkedList();
    }

    @Test
    public void shouldInsertAtBeginning() {
        sll.insertAtBeginning(1);
        sll.insertAtBeginning(2);
        sll.insertAtBeginning(3);
        sll.insertAtBeginning(4);

        assertEquals("4, 3, 2, 1", sll.print());
    }

    @Test
    public void shouldAppend() {
        sll.append(1);
        sll.append(2);
        sll.append(3);
        sll.append(4);

        assertEquals("1, 2, 3, 4", sll.print());
    }

    @Test
    public void shouldInsertAt() {
        sll.append(10);
        sll.append(20);
        sll.insertAt(2, 30);
        sll.insertAt(1, 40);
        sll.insertAt(4, 50);
        sll.insertAt(7, 15);
        sll.insertAt(6, 5);

        assertEquals("40, 10, 30, 50, 20, 5", sll.print());
    }

    @Test
    public void shouldReverse() {
        sll.append(10);
        sll.append(20);
        sll.append(30);
        sll.append(40);
        sll.append(50);

        sll.reverse();
        assertEquals("50, 40, 30, 20, 10", sll.print());
    }
}
