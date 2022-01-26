package uz.elmurodov.repository.task;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.repository.AbstractRepository;
import uz.elmurodov.repository.GenericCrudRepository;
import uz.elmurodov.repository.GenericRepository;
import uz.elmurodov.security.SecurityHolder;

import java.sql.Types;
import java.util.List;


public class TaskRepository extends AbstractRepository implements GenericCrudRepository<
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto,
        Long>, GenericRepository<TaskDto, GenericCriteria> {

    @Override
    public Long create(TaskCreateDto dto) {
        String json = gson.toJson(dto);
        prepareArguments(json, SecurityHolder.authUserSession.getId());
        return (long) callProcedure(property.get("task.create"), Types.BIGINT);
    }

    @Override
    public Boolean update(TaskUpdateDto dto) {
        String json = gson.toJson(dto);
        prepareArguments(json, SecurityHolder.authUserSession.getId());
        return (boolean) callProcedure("task.update", Types.BOOLEAN);
    }

    @Override
    public void delete(Long id) {
        prepareArguments(SecurityHolder.authUserSession.getId(), id);
        callProcedure(property.get("task.delete"), -1);
    }

    @Override
    public TaskDto get(Long id) {
        prepareArguments(id);
        String jsonData = (String) callProcedure(property.get("task.get"), Types.VARCHAR);
        return gson.fromJson(jsonData, TaskDto.class);
    }

    @Override
    public List<TaskDto> list(GenericCriteria criteria) {
        prepareArguments(SecurityHolder.authUserSession.getId());
        String dataJson = (String) callProcedure(property.get("task.list.user"), Types.VARCHAR);
        return gson.fromJson(dataJson, new TypeToken<List<TaskDto>>() {
        }.getType());
    }
/*
    public void addTask(TaskUpdateDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.authUserSession.getId());
        callProcedure("add.comment", Types.BIGINT);
    }*/
}
