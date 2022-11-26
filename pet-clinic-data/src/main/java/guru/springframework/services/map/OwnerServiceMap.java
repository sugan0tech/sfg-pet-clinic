package guru.springframework.services.map;

import guru.springframework.model.Owner;
import guru.springframework.services.CrudService;
import guru.springframework.services.OwnerService;
import guru.springframework.services.PetService;
import guru.springframework.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "MAP"})
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner save(Owner obj) {
//        if(obj != null) {
//            if(obj.getPets() != null){
//                obj.getPets().forEach(pet -> {
//                    if(pet.getPetType() != null){
//                        if(pet.getPetType().getId() == null){
//                            pet.setPetType(petTypeService.save(pet.getPetType()));
//                        }
//                    }else{
//                        throw new RuntimeException("Pet Type is Required");
//                    }
//                });
//            }
//            return super.save(obj);
//        }
          return super.save(obj);
    }

    @Override
    public void delete(Owner obj) {
        super.delete(obj);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Set<Owner> set = super.findAll();
        final Owner res ;
        for(Owner i: set){
            if(i.getLastName() == lastName)
                return i;
        }
        return null;
    }
}
