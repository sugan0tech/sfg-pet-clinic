package guru.springframework.services.map;

import guru.springframework.model.Owner;
import guru.springframework.services.PetService;
import guru.springframework.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().build());
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByLastName() {
    }
}