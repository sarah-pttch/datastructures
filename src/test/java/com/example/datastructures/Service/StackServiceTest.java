package com.example.datastructures.Service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StackServiceTest {

    @Test
    public void testStackPushCorrect(){
        StackService stackService = new StackService();
        stackService.push(2);
        assertEquals(0, stackService.getI());
        assertEquals(2, stackService.getStackValueByIndex(0));
    }

    @Test
    public void testStackRemoveCorrect(){
        StackService stackService = new StackService();
        stackService.push(6);
        stackService.push(7);
        int value = stackService.remove();
        assertEquals(7, value);
        assertEquals(0, stackService.getI());
    }

    @Test
    public void testStackPeekCorrect(){
        StackService stackService = new StackService();
        stackService.push(6);
        stackService.push(12);
        assertEquals(12, stackService.peek());
    }

    @Test
    public void testStackPeekFails_listEmpty(){
        StackService stackService = new StackService();
        assertThrows(ListEmptyException.class, ()->stackService.peek());
    }

    @Test
    public void testStackRemoveFails_listEmpty(){
        StackService stackService = new StackService();
        assertThrows(ListEmptyException.class, ()->stackService.remove());
    }

    @Test
    public void testQueuePushFails_listFull(){
        StackService stackService = new StackService();
        stackService.push(1);
        stackService.push(2);
        stackService.push(3);
        stackService.push(4);
        stackService.push(5);
        stackService.push(6);
        stackService.push(7);
        stackService.push(8);
        stackService.push(9);
        stackService.push(10);
        assertThrows(ListFullException.class, ()->stackService.push(11));
    }
}