package guru.springframework.bootstrap;

import guru.springframework.model.Owner;
import guru.springframework.model.Pet;
import guru.springframework.model.PetType;
import guru.springframework.model.Vet;
import guru.springframework.services.OwnerService;
import guru.springframework.services.PetService;
import guru.springframework.services.PetTypeService;
import guru.springframework.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private PetService petService;
    private VetService vetService;
    private PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, PetService petService, PetTypeService petTypeService, VetService vetService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("sugan");
        owner1.setLastName("muru");
        owner1.setId(1L);
        owner1.setAddress("1201-1 wall street");
        owner1.setCity("NYC");
        owner1.setTelephone("9988899898");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("test");
        owner2.setLastName("test2");
        owner2.setId(2L);
        owner2.setAddress("50-C eb colony");
        owner2.setCity("California");
        owner2.setTelephone("828399823");
        ownerService.save(owner2);

        System.out.println("Owners are saved ....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("mass");
        vet1.setLastName("Monk");

        vetService.save(vet1);
        System.out.println("Loaded vets");

        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setPetType(new PetType());
        pet1.setOwner(owner1);

        petService.save(pet1);
        System.out.println("loaded pet");


    }
}
