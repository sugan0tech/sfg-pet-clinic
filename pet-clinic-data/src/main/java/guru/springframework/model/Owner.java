package guru.springframework.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "owners")
public class Owner extends  Person{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;

    public void addPet(Pet pet){
        pets.add(pet);
    }

    @Override
    public String toString() {
        return "Owner{\n" +
                "pets=" + pets + " , \n" +
                "address='" + address + ", \n" +
                "city='" + city + ", \n" +
                "telephone='" + telephone + ", \n" +
                '}';
    }
}
