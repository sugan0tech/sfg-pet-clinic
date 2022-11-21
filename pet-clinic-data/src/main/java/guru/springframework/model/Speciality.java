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
@Table(name = "specialities")
public class Speciality extends  BaseEntity{
    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "Speciality{" +
                "description='" + description + '\'' +
                '}';
    }
}
