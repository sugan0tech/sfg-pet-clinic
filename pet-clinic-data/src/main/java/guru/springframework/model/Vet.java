package guru.springframework.model;

public class Vet extends  Person{
    private Speciality speciality;

    public Speciality getSpeciality() {
        return speciality;
    }


    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
    @Override
    public String toString() {
        return "Vet{" +
                "name" + super.getFirstName() +
                "speciality=" + speciality +
                '}';
    }
}
