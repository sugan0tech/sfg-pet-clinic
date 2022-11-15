package guru.springframework.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService <T>{
    protected Map<Long, T> map = new HashMap<>();
    Set<T> findAll(){
        return new HashSet<>(map.values());

    }
    T findById(Long id){
        return map.get(id);
    }
    T save(Long id, T obj){
        if(!map.containsKey(id)){
            map.put((long) map.size(), obj);
        }
        return obj;
    }
    void deleteById(Long id){
        map.remove(id);
    }
    void delete(T obj){
        map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }
}
