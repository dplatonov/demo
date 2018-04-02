package dplatonov.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import dplatonov.dao.UserDao;
import dplatonov.model.User;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTestJunit4 {

  private UserService service;

  @MockBean
  private UserDao dao;

  private final Long id = 1L;
  private User expectedUser;
  private List<User> expectedUsers;

  @Before
  public void setUp() {
    service = Mockito.spy(new UserService(dao));

    expectedUser = new User();
    expectedUser.setId(id);

    expectedUsers = Arrays.asList(expectedUser, expectedUser);
  }

  @Test
  public void showMeTheMagic() {
    when(dao.findAllByDeletedIsFalseAndEnabledIsTrue()).thenReturn(expectedUsers);
    assertTrue(CollectionUtils.isNotEmpty(service.showMeTheMagic()));
  }
}
