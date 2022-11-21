package guru.springframework.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "types")
public class PetType extends BaseEntity{
    @Column(name = "name")
    private  String name;

    @Override
    public String toString() {
        return "PetType{\n" +
                "name='" + name + "'\n" +
                '}';
    }
}
