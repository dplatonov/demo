package dplatonov.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author platonov.d.m@gmail.com
 *     <p>Basic entity <a>This entity should extends each entity</a>
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = -4686489713108373323L;
  private Date createDate;
  private Date lastUpdate;
  private Boolean deleted;
  private Boolean enabled;

  @CreatedDate
  @Column(name = "create_date", nullable = false)
  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @LastModifiedDate
  @Column(name = "last_update", nullable = false)
  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  @Column(name = "deleted", nullable = false)
  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  @Column(name = "enabled", nullable = false)
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public String toString() {
    return "BaseEntity{" +
        "createDate=" + createDate +
        ", lastUpdate=" + lastUpdate +
        ", deleted=" + deleted +
        ", enabled=" + enabled +
        '}';
  }
}
