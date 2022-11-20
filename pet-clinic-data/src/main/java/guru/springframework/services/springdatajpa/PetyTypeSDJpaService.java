package guru.springframework.services.springdatajpa;

import guru.springframework.model.PetType;
import guru.springframework.repositories.PetTypeRepository;
import guru.springframework.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("JPA")
public class PetyTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetyTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);

        return petTypes;
    }

    @Override
    public PetType save(PetType obj) {
        return petTypeRepository.save(obj);
    }

    @Override
    public void delete(PetType obj) {
        petTypeRepository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
