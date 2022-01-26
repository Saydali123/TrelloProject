package uz.elmurodov.repository.project;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.AbstractRepository;
import uz.elmurodov.repository.GenericCrudRepository;
import uz.elmurodov.repository.GenericRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.utils.BaseUtils;

import java.sql.Types;
import java.util.List;

public class ProjectRepository extends AbstractRepository implements GenericCrudRepository<
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        Long>, GenericRepository<ProjectDto, GenericCriteria> {
    @Override
    public Long create(ProjectCreateDto dto) {
        prepareArguments(BaseUtils.gson.toJson(dto), SecurityHolder.authUserSession.getId());
        return (Long) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("create.project"), Types.BIGINT);
    }


    @Override
    public Boolean update(ProjectUpdateDto dto) {
        prepareArguments(SecurityHolder.authUserSession.getId(), BaseUtils.gson.toJson(dto));
        return (boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("unblock.project"), Types.VARCHAR);
    }

    @Override
    public void delete(Long id) {
        prepareArguments(SecurityHolder.authUserSession.getId(), id);
        callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("delete.project"), -1);
    }

    @Override
    public ProjectDto get(Long id) {
        prepareArguments(id, SecurityHolder.authUserSession.getId());
        String dataJson = (String) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("project.get"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(dataJson, ProjectDto.class);
    }

    @Override
    public List<ProjectDto> list(GenericCriteria criteria) {
        prepareArguments(SecurityHolder.authUserSession.getId());
        String data = (String) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("list.project"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(data, new TypeToken<List<ProjectDto>>() {
        }.getType());
    }

}
