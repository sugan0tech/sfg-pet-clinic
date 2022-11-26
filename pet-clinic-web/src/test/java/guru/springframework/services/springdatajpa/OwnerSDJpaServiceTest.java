package guru.springframework.services.springdatajpa;

import guru.springframework.model.Owner;
import guru.springframework.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;
    @InjectMocks
    private OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(2L).lastName("Smith").build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName("Smith");
        assertEquals("Smith", smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        Owner returnOwner = Owner.builder().id(2L).lastName("Smith").build();
        when(ownerRepository.findById(any())).thenReturn(Optional.ofNullable(returnOwner));
        Owner owner = service.findById(2L);
        assertEquals(2L, owner.getId());
        verify(ownerRepository).findById(any());
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}