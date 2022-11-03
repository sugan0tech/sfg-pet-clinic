package guru.springframework.services.map;

import guru.springframework.model.Pet;
import guru.springframework.services.CrudService;
import guru.springframework.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet obj) {
        super.delete(obj);

    }

    @Override
    public Pet save(Pet obj) {
        return super.save(obj.getId(), obj);
    }
}
