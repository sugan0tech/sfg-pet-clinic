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
        Owner owner  = Owner.builder().build();
        owner.setId(0L);
        ownerServiceMap.save(owner);
    }

    @Test
    void findById() {
        assertEquals(0L, ownerServiceMap.findById(0L).getId());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        Owner owner = Owner.builder().build();
        owner.setId(1L);
        ownerServiceMap.deleteById(1L);
        assertNull(ownerServiceMap.findById(1L));
    }

    @Test
    void save() {
        Owner owner = Owner.builder().build();
        owner.setId(1L);
        assertEquals(owner, ownerServiceMap.save(owner));
    }

    @Test
    void delete() {
        Owner owner = Owner.builder().build();
        owner.setId(2L);
        ownerServiceMap.delete(owner);
        assertNull(ownerServiceMap.findById(2L));
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().build();
        owner.setLastName("yeah");
        ownerServiceMap.save(owner);
        assertEquals(owner, ownerServiceMap.findByLastName("yeah"));
    }
}