package com.example.datastructures.Controller;

import com.example.datastructures.Service.QueueService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = QueueController.class)
class QueueControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    QueueService queueService;

    @Test
    public void queuePush_whenCalledWithValidParam_thenVerifyControllerReturnsOk() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/queue/push?number=2")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

//    @Test
//    public void testQueuePushCorrect(){
//        QueueController queueController = new QueueController();
//        assertEquals("You added the number 7 to the queue", queueController.push(7));
//    }
//
//    @Test
//    public void testQueueRemoveCorrect(){
//        QueueController queueController = new QueueController();
//        queueController.push(12);
//        assertEquals("You removed the number 12 from the queue", queueController.remove());
//    }

}