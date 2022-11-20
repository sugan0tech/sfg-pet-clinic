package guru.springframework.bootstrap;

import guru.springframework.model.*;
import guru.springframework.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private PetService petService;
    private VetService vetService;
    private PetTypeService petTypeService;
    private SpecialityService specialityService;
    private VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }



    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("sugan");
        owner1.setLastName("muru");
        owner1.setId(1L);
        owner1.setAddress("1201-1 wall street");
        owner1.setCity("NYC");
        owner1.setTelephone("9988899898");

        Pet sugDog = new Pet();
        sugDog.setPetType(dog);
        sugDog.setOwner(owner1);
        sugDog.setBirthDate(LocalDate.now());
        petService.save(sugDog);

        owner1.addPet(sugDog);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("test");
        owner2.setLastName("test2");
        owner2.setId(2L);
        owner2.setAddress("50-C eb colony");
        owner2.setCity("California");
        owner2.setTelephone("828399823");

        Pet testDog = new Pet();
        testDog.setPetType(dog);
        testDog.setOwner(owner2);
        testDog.setBirthDate(LocalDate.now());
        petService.save(testDog);

        owner2.addPet(testDog);
        ownerService.save(owner2);

        System.out.println("Owners are saved ....");
        System.out.println(owner1 +"\n\n"+ owner2);

        Speciality surgerion = new Speciality();
        surgerion.setDescription("surgerion");
        specialityService.save(surgerion);
        Speciality anesthesian = new Speciality();
        anesthesian.setDescription("anesthesian");
        specialityService.save(anesthesian);


        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("mass");
        vet1.setLastName("Monk");

        vetService.save(vet1);
        System.out.println(vet1);
        System.out.println("Loaded vets");

        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setPetType(new PetType());
        pet1.setOwner(owner1);

        petService.save(pet1);
        System.out.println("loaded pet");

        Visit vist = new Visit();
        vist.setPet(pet1);
        vist.setDate(LocalDate.now());
        vist.setDescription("squuzy cat");
        visitService.save(vist);
    }
}
