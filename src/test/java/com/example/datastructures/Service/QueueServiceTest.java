package com.example.datastructures.Service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QueueServiceTest {

    @Test
    public void testQueuePushCorrect(){
        QueueService queueService = new QueueService();
        queueService.push(2);
        assertEquals(1, queueService.getI());
        assertEquals(2, queueService.getQueueValue(0));
    }

    @Test
    public void testQueueRemoveCorrect(){
        QueueService queueService = new QueueService();
        queueService.push(7);
        queueService.push(6);
        int value = queueService.remove();
        assertEquals(7, value);
        assertEquals(1, queueService.getI());
        assertEquals(6, queueService.getQueueValue(0));
    }

    @Test
    public void testQueuePeekCorrect(){
        QueueService queueService = new QueueService();
        queueService.push(12);
        queueService.push(6);
        assertEquals(12, queueService.peek());
    }

    @Test
    public void testQueuePeekFails(){
        QueueService queueService = new QueueService();
        assertThrows(ListEmptyException.class, ()->queueService.peek());
    }

    @Test
    public void testQueueRemoveFails(){
        QueueService queueService = new QueueService();
        assertThrows(ListEmptyException.class, ()->queueService.remove());
    }

    @Test
    public void testQueuePushFails(){
        QueueService queueService = new QueueService();
        queueService.push(1);
        queueService.push(2);
        queueService.push(3);
        queueService.push(4);
        queueService.push(5);
        queueService.push(6);
        queueService.push(7);
        queueService.push(8);
        queueService.push(9);
        queueService.push(10);
        assertThrows(ListFullException.class, ()->queueService.push(11));
    }

}