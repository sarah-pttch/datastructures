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



//    @Test
//    public void testStackPushCorrect(){
//        StackController stackController = new StackController();
//        assertEquals("You added the number 7 to the stack", stackController.push(7));
//    }
//
//    @Test
//    public void testStackPeekCorrect(){
//        StackController stackController = new StackController();
//        stackController.push(12);
//        assertEquals("The number on top of the stack is 12", stackController.peek());
//    }

//    @Test
//    public void testStackIndexOutOfBounds(){
//        StackController stackController = new StackController();
//        assertThrows(IndexOutOfBoundsException.class, stackController::peek);
//    }

}