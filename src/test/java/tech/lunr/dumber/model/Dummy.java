package tech.lunr.dumber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Dummy entity for running tests
 *
 * @author IB
 */
@Entity
public class Dummy {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 1)
    @Max(value = 5)
    @Pattern(regexp = "[0-3]([a-c]|[e-g]{1,2})")
    private String name;

    private int ord;

    public Dummy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Dummy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ord=" + ord +
                '}';
    }
}
