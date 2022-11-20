package guru.springframework.services.map;

import guru.springframework.model.Pet;
import guru.springframework.services.CrudService;
import guru.springframework.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "MAP"})
public class PetServiceMap extends AbstractMapService<Pet> implements PetService{
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
        return super.save(obj);
    }
}
