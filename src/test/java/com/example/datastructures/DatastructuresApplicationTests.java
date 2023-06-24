package com.example.datastructures;

import com.example.datastructures.Controller.QueueController;
import com.example.datastructures.Controller.StackController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DatastructuresApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testStackPushCorrect(){
        StackController stackController = new StackController();
        assertEquals("You added the number 7 to the stack", stackController.push(7));
    }

    @Test
    public void testQueuePushCorrect(){
        QueueController queueController = new QueueController();
        assertEquals("You added the number 7 to the queue", queueController.push(7));
    }

//    @Test
//    public void testStackTypeMismatch(){
//        StackController stackController = new StackController();
//        assertThrows(MethodArgumentTypeMismatchException.class, ()->stackController.push(1.23));
//    }

    @Test
    public void testStackPeekCorrect(){
        StackController stackController = new StackController();
        stackController.push(12);
        assertEquals("The number on top of the stack is 12", stackController.peek());
    }

    @Test
    public void testQueueRemoveCorrect(){
        QueueController queueController = new QueueController();
        queueController.push(12);
        assertEquals("You removed the number 12 from the queue", queueController.remove());
    }

    @Test
    public void testStackIndexOutOfBounds(){
        StackController stackController = new StackController();
        assertThrows(IndexOutOfBoundsException.class, ()->stackController.peek());
    }


}
