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

    @Test
    public void queuePush_whenCalledWithInvalidParam_thenVerifyControllerReturnsClientError() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/queue/push?number=2,4")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    //Test fails
    @Test
    public void queuePeek_whenCalledOnEmptyList_thenVerifyControllerReturnsClientError() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/queue/peek")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    //Test fails
    @Test
    public void queueRemove_whenCalledOnEmptyList_thenVerifyControllerReturnsClientError() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/queue/remove")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void queueRemove_whenCalledOnFilledList_thenVerifyControllerReturnsOk() throws Exception {
        queueService.push(12);
        mvc.perform(
                MockMvcRequestBuilders.get("/queue/remove")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void queuePeek_whenCalledOnFilledList_thenVerifyControllerReturnsOk() throws Exception {
        queueService.push(12);
        mvc.perform(
                        MockMvcRequestBuilders.get("/queue/peek")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}