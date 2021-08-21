package com.myproject.technicaltest;

import com.myproject.technicaltest.controller.UserController;
import com.myproject.technicaltest.entity.User;
import com.myproject.technicaltest.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TechnicalTestApplicationTests class for the unit tests.
 * @author Yasmine MANSOURI
 *
 */

@WithMockUser
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TechnicalTestApplication.class)
@WebMvcTest(UserController.class)
public class TechnicalTestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    User mockUser = new User("Username-34", "1990-01-23", "France", "null", "null");

    String exampleUserJson = "{\"username\":\"Username-34\",\"birthdate\":\"1990-01-23\",\"residenceCountry\":\"France\",\"phoneNumber\":\"null\",\"gender\":\"null\"}";


    @Test
    public void createUser() throws Exception {

        // UserService.saveUser to respond back with mockUser
        Mockito.when(
                userService.saveUser(Mockito.any())).thenReturn(mockUser);

        // Send user as body
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8080/user")
                .accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
                .contentType(MediaType.APPLICATION_JSON);


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }

    @Test
    public void retrieveDetailsForUser() throws Exception {

        Mockito.when(
                userService.getUserById(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(mockUser));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "http://localhost:8080/user/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{\"username\":\"Username-34\", \"birthdate\":\"1990-01-23\", \"residenceCountry\":\"France\",\"phoneNumber\":\"null\",\"gender\":\"null\"}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void updateUser() throws Exception {
        Mockito.when(
                userService.updateUser(Mockito.any())).thenReturn(mockUser);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("http://localhost:8080/user/1")
                .accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("http://localhost:8080/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

}
