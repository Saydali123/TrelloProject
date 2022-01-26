package uz.elmurodov.repository.user;

import uz.elmurodov.criterias.UserCriteria;
import uz.elmurodov.dtos.auth.UserCreateDto;
import uz.elmurodov.dtos.auth.UserUpdateDto;
import uz.elmurodov.dtos.user.BlockUserDto;
import uz.elmurodov.dtos.user.UserDto;
import uz.elmurodov.exception.ApiRuntimeException;
import uz.elmurodov.exception.CustomSQLException;
import uz.elmurodov.repository.AbstractRepository;
import uz.elmurodov.repository.GenericCrudRepository;
import uz.elmurodov.repository.GenericRepository;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;
import java.util.List;

public class UserRepository extends AbstractRepository implements GenericCrudRepository<UserDto, UserCreateDto, UserUpdateDto, Long>, GenericRepository<UserDto, UserCriteria> {

    @Override
    public Long create(UserCreateDto dto) {
        String json = BaseUtils.gson.toJson(dto);
        prepareArguments(json, sessionUserId());
        return callProcedure(property.get("user.create"), Long.class);
    }

    @Override
    public UserDto get(Long id) {
        prepareArguments(id, sessionUserId());
        String jsonDATA = callProcedure(property.get("user.details"), String.class);
        return gson.fromJson(jsonDATA, UserDto.class);
    }

    @Override
    public Boolean update(UserUpdateDto dto) {
        prepareArguments(gson.toJson(dto), sessionUserId());
        return callProcedure(property.get("user.update"), Boolean.class);
    }

    @Override
    public void delete(Long id) {
        try {
            prepareArguments(id, sessionUserId());
            callProcedure(property.get("user.delete"), Types.BOOLEAN);
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public List<UserDto> list(UserCriteria criteria) {
        return null;
    }

    public void block(BlockUserDto dto) {
        prepareArguments(gson.toJson(dto), sessionUserId());
        callProcedure(property.get("user.block"), Types.BOOLEAN);
    }
}
