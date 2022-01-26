package uz.elmurodov.repository;

import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.GenericDto;

import java.util.List;

public interface GenericRepository<D extends GenericDto, C extends GenericCriteria> {
    List<D> list(C criteria);
}
