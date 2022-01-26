package uz.elmurodov.services.project;

import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.project.ProjectDto;
import uz.elmurodov.dtos.project.ProjectUpdateDto;
import uz.elmurodov.exception.ApiRuntimeException;
import uz.elmurodov.exception.CustomSQLException;
import uz.elmurodov.repository.project.ProjectRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.AbstractService;
import uz.elmurodov.services.GenericCrudService;
import uz.elmurodov.services.GenericService;

import java.util.List;


public class ProjectService extends AbstractService<
        ProjectRepository> implements GenericCrudService<
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        Long>, GenericService<ProjectDto, GenericCriteria> {

    public ProjectService(ProjectRepository repository) {
        super(repository);
    }


    @Override
    public ResponseEntity<Data<Long>> create(ProjectCreateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(repository.create(dto)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<ProjectDto>> get(Long id) {
        try {
            ProjectDto projectDto = repository.get(id);
            return new ResponseEntity<>(new Data<>(projectDto));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());

        }
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(ProjectUpdateDto dto) {
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
    public ResponseEntity<Data<List<ProjectDto>>> list(GenericCriteria criteria) {
        try {
            List<ProjectDto> projectDtoList = repository.list(new GenericCriteria());
            return new ResponseEntity<>(new Data<>(projectDtoList, projectDtoList.size()));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

//    public ResponseEntity<Data<List<UserDto>>> getMembers(Long id) {
//        try {
//            List<Session> authUsers = repository.getMembers(id);
//            return new ResponseEntity<>(new Data<>(authUsers));
//        } catch (CustomerSQLException e) {
//            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
//        }
//    }
}
