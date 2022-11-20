package guru.springframework.services.map;

import guru.springframework.model.Visit;
import guru.springframework.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "MAP"})
public class VisitServiceMap extends  AbstractMapService<Visit> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit obj) {
        if(obj == null || obj.getPet().getOwner() == null || obj.getPet().getId() == null || obj.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(obj);
    }

    @Override
    public void delete(Visit obj) {
        super.delete(obj);
    }
}
