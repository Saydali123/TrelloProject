package uz.elmurodov.utils.validators;

import uz.elmurodov.dtos.GenericBaseDto;
import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.exception.InvalidInputException;
import uz.elmurodov.utils.BaseUtils;

import java.io.Serializable;


/**
 * Base validator
 *
 * @param <CD> create dto
 * @param <UD> update dto
 * @param <K>  identity key type
 */
public abstract class BaseValidator<CD extends GenericBaseDto, UD extends GenericDto, K extends Serializable> extends AbstractValidator {

    protected BaseValidator(BaseUtils utils) {
        super(utils);
    }

    protected abstract void validOnCreate(CD dto) throws InvalidInputException;

    protected abstract void validOnUpdate(UD dto) throws InvalidInputException;

    protected abstract void validKey(K id) throws InvalidInputException;

}
