package uz.elmurodov.services.task;

import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.exception.ApiRuntimeException;
import uz.elmurodov.exception.CustomSQLException;
import uz.elmurodov.repository.task.TaskRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.AbstractService;
import uz.elmurodov.services.GenericCrudService;
import uz.elmurodov.services.GenericService;

import java.util.List;


public class TaskService extends AbstractService<TaskRepository> implements GenericCrudService<
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto,
        Long>,
        GenericService<TaskDto, GenericCriteria> {

    public TaskService(TaskRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<Long>> create(TaskCreateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(repository.create(dto)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<TaskDto>> get(Long id) {
        try {
            return new ResponseEntity<>(new Data<>(repository.get(id)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(TaskUpdateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(repository.update(dto)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        try {
            repository.delete(id);
            return new ResponseEntity<>(new Data<>(null));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<List<TaskDto>>> list(GenericCriteria criteria) {
        try {
            return new ResponseEntity<>(new Data<>(repository.list(criteria)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }
}
