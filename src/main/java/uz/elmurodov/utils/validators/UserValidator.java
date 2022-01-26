package uz.elmurodov.utils.validators;

import uz.elmurodov.dtos.auth.UserCreateDto;
import uz.elmurodov.dtos.auth.UserUpdateDto;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.exception.InvalidInputException;
import uz.elmurodov.utils.BaseUtils;

import java.util.Objects;

public class UserValidator extends BaseValidator<UserCreateDto, UserUpdateDto, Long> {

    public UserValidator(BaseUtils utils) {
        super(utils);
    }

    @Override
    public void validOnCreate(UserCreateDto dto) throws InvalidInputException {

    }

    @Override
    public void validOnUpdate(UserUpdateDto dto) throws InvalidInputException {

    }

    @Override
    public void validKey(Long id) throws InvalidInputException {
        if (Objects.isNull(id))
            throw new InvalidInputException("ID_COULD_NOT_BE_NULL", HttpStatus.HTTP_400);
    }
}
