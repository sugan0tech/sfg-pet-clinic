package guru.springframework.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends  BaseEntity{
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @OneToMany(fetch =  FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pet")
    @JoinTable
    private Set<Visit> visits;

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return " Pet{\n" +
                "petType=" + petType + " ,\n" +
                "owner id=" + owner.getId() + " , \n" +
                "birthDate=" + birthDate + " , \n" +
                '}';
    }
}
