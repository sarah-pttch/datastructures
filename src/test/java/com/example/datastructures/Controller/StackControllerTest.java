package com.example.datastructures.Controller;

import com.example.datastructures.Service.StackService;
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
@WebMvcTest(controllers = StackController.class)
class StackControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    StackService stackService;

    @Test
    public void stackPush_whenCalledWithValidParam_thenVerifyControllerReturnsOk() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/stack/push?number=2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void stackPush_whenCalledWithInvalidParam_thenVerifyControllerReturnsClientError() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/stack/push?number=2,4")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    //Test fails
    @Test
    public void stackPeek_whenCalledOnEmptyList_thenVerifyControllerReturnsClientError() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/stack/peek")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    //Test fails
    @Test
    public void stackRemove_whenCalledOnEmptyList_thenVerifyControllerReturnsClientError() throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/stack/remove")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void stackRemove_whenCalledOnFilledList_thenVerifyControllerReturnsOk() throws Exception {
        stackService.push(12);
        mvc.perform(
                        MockMvcRequestBuilders.get("/stack/remove")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void stackPeek_whenCalledOnFilledList_thenVerifyControllerReturnsOk() throws Exception {
        stackService.push(12);
        mvc.perform(
                        MockMvcRequestBuilders.get("/stack/peek")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}