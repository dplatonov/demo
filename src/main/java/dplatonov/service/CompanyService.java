package dplatonov.service;

import dplatonov.dao.CompanyDao;
import dplatonov.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService extends GenericService<Company> {

  @Autowired
  public CompanyService(CompanyDao dao) {
    super(Company.class, dao);
  }
}
