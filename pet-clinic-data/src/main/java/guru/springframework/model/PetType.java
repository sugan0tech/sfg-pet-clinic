package guru.springframework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity{
    @Column(name = "name")
    private  String name;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "PetType{\n" +
                "name='" + name + "'\n" +
                '}';
    }
}
