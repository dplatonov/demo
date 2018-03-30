package dplatonov.dao;

import dplatonov.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends GenericDao<User> {

  List<User> findAllByDeletedIsFalseAndEnabledIsTrue();
}
