package uz.elmurodov.services;

import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;

import java.util.List;

public interface GenericService<D extends GenericDto, C extends GenericCriteria> {

    ResponseEntity<Data<List<D>>> list(C criteria);

}
