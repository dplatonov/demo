package dplatonov.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "company", schema = "public")
@DynamicUpdate
public class Company extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -2551689075665210134L;

  private Long id;
  private String name;
  private Set<User> users;

  @Id
  @SequenceGenerator(name = "company_id_seq", sequenceName = "company_id_seq")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "company_id_seq")
  @Column(name = "id", unique = true, nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "company")
  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "Company{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", users=" + users +
        '}';
  }
}
