package uz.elmurodov.repository.column;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.criterias.project.ProjectCriteria;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.exception.ApiRuntimeException;
import uz.elmurodov.exception.CustomSQLException;
import uz.elmurodov.repository.AbstractRepository;
import uz.elmurodov.repository.GenericCrudRepository;
import uz.elmurodov.repository.GenericRepository;
import uz.elmurodov.security.SecurityHolder;

import java.sql.Types;
import java.util.List;

public class ColumnRepository extends AbstractRepository
        implements GenericCrudRepository<ColumnDto,
        ColumnCreateDto,
        ColumnUpdateDto,
        Long>, GenericRepository<ColumnDto, ProjectCriteria> {


    @Override
    public Long create(ColumnCreateDto dto) {
        try {
            prepareArguments(gson.toJson(dto), SecurityHolder.authUserSession.getId());
            return callProcedure(property.get("column.create"), Long.class);
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ColumnDto get(Long id) {
        return null;
    }

    @Override
    public Boolean update(ColumnUpdateDto dto) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ColumnDto> list(ProjectCriteria criteria) {
        prepareArguments(criteria.getProjectId());
        String jsonData = (String) callProcedure(property.get("column.list"), Types.VARCHAR);
        return gson.fromJson(jsonData, new TypeToken<List<ColumnDto>>() {
        }.getType());
    }
}
