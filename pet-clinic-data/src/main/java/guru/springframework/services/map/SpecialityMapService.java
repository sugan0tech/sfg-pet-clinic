package guru.springframework.services.map;

import guru.springframework.model.Speciality;
import guru.springframework.services.SpecialityService;

import java.util.Set;

public class SpecialityMapService extends AbstractMapService<Speciality> implements SpecialityService{

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality obj) {
        super.delete(obj);
    }

    @Override
    public Speciality save(Speciality obj) {
        return super.save(obj);
    }
}
