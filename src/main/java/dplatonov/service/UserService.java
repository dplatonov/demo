package dplatonov.service;

import dplatonov.dao.UserDao;
import dplatonov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User> {

  @Autowired
  public UserService(UserDao dao) {
    super(User.class, dao);
  }
}
