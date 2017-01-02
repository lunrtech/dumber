package tech.lunr.dumber.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Dummy entity for running tests
 *
 * @author IB
 */
@Entity
public class Dummy  extends AbstractEntity<Long> {

    private String name;

    private int ord;

    @Enumerated(EnumType.STRING)
    private DummyEnum dummyType;

    private Child child;

    private List<Child> childs;

    public Dummy() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    public DummyEnum getDummyType() {
        return dummyType;
    }

    public void setDummyType(DummyEnum dummyType) {
        this.dummyType = dummyType;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "name='" + name + '\'' +
                ", ord=" + ord +
                ", dummyType=" + dummyType +
                ", child=" + child +
                ", childs=" + childs +
                '}';
    }
}
