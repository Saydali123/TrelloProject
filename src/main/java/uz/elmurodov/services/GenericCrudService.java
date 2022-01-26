package uz.elmurodov.services;

import uz.elmurodov.dtos.GenericBaseDto;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;

import java.io.Serializable;

public interface GenericCrudService<
        D extends GenericDto,
        CD extends GenericBaseDto,
        UD extends GenericDto,
        K extends Serializable> {

    ResponseEntity<Data<K>> create(CD dto);

    ResponseEntity<Data<D>> get(K id);

    ResponseEntity<Data<Boolean>> update(UD dto);

    ResponseEntity<Data<Void>> delete(K id);

}
