package dplatonov.service;

import dplatonov.dao.GenericDao;
import dplatonov.model.BaseEntity;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author platonov.d.m@gmail.com
 *     <p>Basic service <a>This service should extends each setvice</a>
 */
@Transactional
public class GenericService<T> {

  private Class<T> entityClass;
  private GenericDao<T> dao;

  public GenericService(Class<T> entityClass, GenericDao<T> dao) {
    this.entityClass = entityClass;
    this.dao = dao;
  }

  public T findById(Long id) {
    return dao.findById(id).get();
  }

  public List<T> findAll() {
    return dao.findAll();
  }

  public T save(T t) {
    return dao.save(t);
  }

  public void delete(Long id) {
    if (BaseEntity.class.isAssignableFrom(entityClass)) {
      dao.deleteBaseEntity(id);
    } else {
      dao.delete(findById(id));
    }
  }
}
