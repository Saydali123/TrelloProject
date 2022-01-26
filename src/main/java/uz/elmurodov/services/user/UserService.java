package uz.elmurodov.services.user;

import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.auth.UserCreateDto;
import uz.elmurodov.dtos.auth.UserUpdateDto;
import uz.elmurodov.dtos.user.BlockUserDto;
import uz.elmurodov.dtos.user.UserDto;
import uz.elmurodov.exception.ApiRuntimeException;
import uz.elmurodov.exception.BaseException;
import uz.elmurodov.exception.CustomSQLException;
import uz.elmurodov.repository.user.UserRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.AbstractService;
import uz.elmurodov.services.GenericCrudService;
import uz.elmurodov.services.GenericService;
import uz.elmurodov.utils.validators.UserValidator;

import java.util.List;

public class UserService extends AbstractService<UserRepository>
        implements GenericCrudService<UserDto, UserCreateDto, UserUpdateDto, Long>,
        GenericService<UserDto, GenericCriteria> {

    private final UserValidator validator;

    public UserService(UserRepository repository, UserValidator validator) {
        super(repository);
        this.validator = validator;
    }

    @Override
    public ResponseEntity<Data<Long>> create(UserCreateDto dto) {
        try {
            validator.validOnCreate(dto);
            Long userId = repository.create(dto);
            return new ResponseEntity<>(new Data<>(userId));
        } catch (BaseException e) {
            throw new ApiRuntimeException(e.getMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<UserDto>> get(Long id) {
        try {
            return new ResponseEntity<>(new Data<>(repository.get(id)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(UserUpdateDto dto) {
        try {
            validator.validOnUpdate(dto);
            return new ResponseEntity<>(new Data<>(repository.update(dto)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        try {
            validator.validKey(id);
            repository.delete(id);
            return new ResponseEntity<>(new Data<>(null));
        } catch (BaseException e) {
            throw new ApiRuntimeException(e.getMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<List<UserDto>>> list(GenericCriteria criteria) {
        return null;
    }

    public ResponseEntity<Data<Boolean>> block(BlockUserDto dto) {
        repository.block(dto);
        return null;
    }
}
