package com.gft.petclinicdata.services.map;

import com.gft.petclinicdata.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService < T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if (object != null){
            if (object.getId() == null){
                object.setId(getNextId());
            }
        } else {
            throw new RuntimeException();
        }
        map.put(getNextId(), object);
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete (T object){
        map.entrySet().removeIf(
                entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        if (map.size()==0) {
            return 1L;
        }
        return Collections.max(map.keySet()) + 1;
    }
}
