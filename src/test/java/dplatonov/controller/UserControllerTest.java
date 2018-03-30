package dplatonov.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dplatonov.model.User;
import dplatonov.service.UserService;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private UserService service;

  private final Long id = 1L;
  private User expectedUser;
  private List<User> expectedUsers;

  @Before
  public void setUp() {
    expectedUser = new User();
    expectedUser.setId(1L);

    expectedUsers = Arrays.asList(expectedUser, expectedUser);
  }

  @Test
  public void getUsers() throws Exception {
    when(service.findAll()).thenReturn(expectedUsers);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/user")).andExpect(status().isOk());
  }

  @Test
  public void getById() throws Exception {
    when(service.findById(id)).thenReturn(expectedUser);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/user/" + id)).andExpect(status().isOk());
  }
}
