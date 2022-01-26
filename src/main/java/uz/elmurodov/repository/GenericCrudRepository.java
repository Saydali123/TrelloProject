package uz.elmurodov.repository;

import uz.elmurodov.dtos.GenericBaseDto;
import uz.elmurodov.dtos.GenericDto;

import java.io.Serializable;


/**
 * @param <D>  dto
 * @param <CD> create dto
 * @param <UD> update dto
 * @param <K>  primary key
 */
public interface GenericCrudRepository<
        D extends GenericDto,
        CD extends GenericBaseDto,
        UD extends GenericDto,
        K extends Serializable> {
    K create(CD dto);

    D get(K id);

    Boolean update(UD dto);

    void delete(K id);
}
