package guru.springframework.bootstrap;

import guru.springframework.model.Owner;
import guru.springframework.model.Pet;
import guru.springframework.model.PetType;
import guru.springframework.model.Vet;
import guru.springframework.services.OwnerService;
import guru.springframework.services.PetService;
import guru.springframework.services.VetService;
import guru.springframework.services.map.OwnerServiceMap;
import guru.springframework.services.map.PetServiceMap;
import guru.springframework.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private PetService petService;
    private VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("sugan");
        owner1.setLastName("muru");
        owner1.setId(1L);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("test");
        owner2.setLastName("test2");
        owner2.setId(2L);
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
