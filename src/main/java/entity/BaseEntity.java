package entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by berard on 14.02.17.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    protected int id;

    public int getId() {
        return id;
    }
}
