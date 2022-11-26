package guru.springframework.services.springdatajpa;

import guru.springframework.model.Owner;
import guru.springframework.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;
    @InjectMocks
    private OwnerSDJpaService service;

    private Owner returnOwner;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        returnOwner = Owner.builder().id(1L).lastName("Smith").build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName("Smith");
        assertEquals("Smith", smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        returnOwner = Owner.builder().id(2L).lastName("Smith").build();
        when(ownerRepository.findById(any())).thenReturn(Optional.ofNullable(returnOwner));
        Owner owner = service.findById(2L);
        assertEquals(2L, owner.getId());
        verify(ownerRepository).findById(any());
    }
    @Test
    void findByIdNull() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(2L);
        assertNull(owner);
        verify(ownerRepository).findById(anyLong());
    }


    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
        assertEquals(2, service.findAll().size());
        verify(ownerRepository).findAll();

    }

    @Test
    void save() {
        returnOwner = Owner.builder().id(4L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        assertEquals(returnOwner, service.save(returnOwner));
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}