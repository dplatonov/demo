package dplatonov.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import dplatonov.dao.UserDao;
import dplatonov.extension.MockitoExtension;
import dplatonov.model.User;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  private UserService service;

  private final Long id = 1L;
  private User expectedUser;
  private List<User> expectedUsers;

  @BeforeEach
  void setUp(@Mock UserDao dao) {
    service = Mockito.spy(new UserService(dao));

    expectedUser = new User();
    expectedUser.setId(id);

    expectedUsers = Arrays.asList(expectedUser, expectedUser);
  }

  @Test
  @DisplayName("test message")
  void showMeTheMagic(@Mock UserDao dao) {
    when(dao.findAllByDeletedIsFalseAndEnabledIsTrue()).thenReturn(expectedUsers);
    assertTrue(CollectionUtils.isNotEmpty(service.showMeTheMagic()));
  }

}