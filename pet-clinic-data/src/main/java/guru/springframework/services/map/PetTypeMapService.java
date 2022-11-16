package guru.springframework.services.map;

import guru.springframework.model.PetType;
import guru.springframework.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService{

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType obj) {
        super.delete(obj);
    }

    @Override
    public PetType save(PetType obj) {
        return super.save(obj);
    }
}
