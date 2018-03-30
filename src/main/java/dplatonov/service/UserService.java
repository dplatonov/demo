package dplatonov.service;

import dplatonov.dao.UserDao;
import dplatonov.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends GenericService<User> {
  private final UserDao dao;

  @Autowired
  public UserService(UserDao dao) {
    super(User.class, dao);
    this.dao = dao;
  }

  public List<User> showMeTheMagic() {
    return dao.findAllByDeletedIsFalseAndEnabledIsTrue();
  }
}
