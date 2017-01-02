package tech.lunr.dumber.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base entity class
 *
 * @author bignacz
 */
@MappedSuperclass
public abstract class AbstractEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public AbstractEntity<T> id(T id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
            "id=" + id +
            '}';
    }
}
