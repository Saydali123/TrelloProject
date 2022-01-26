package uz.elmurodov.services.organization;

import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.exception.ApiRuntimeException;
import uz.elmurodov.exception.CustomSQLException;
import uz.elmurodov.repository.organization.OrganizationRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.AbstractService;
import uz.elmurodov.services.GenericCrudService;
import uz.elmurodov.services.GenericService;

import java.util.List;

public class OrganizationService extends AbstractService<OrganizationRepository>
        implements GenericCrudService<
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        Long>, GenericService<OrganizationDto, GenericCriteria> {

    public OrganizationService(OrganizationRepository repository) {
        super(repository);
    }


    @Override
    public ResponseEntity<Data<Long>> create(OrganizationCreateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(repository.create(dto)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<OrganizationDto>> get(Long id) {
        try {
            OrganizationDto organizationDto = repository.get(id);
            return new ResponseEntity<>(new Data<>(organizationDto));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(OrganizationUpdateDto dto) {
        try {
            if (!hasPermission("ORGANIZATION_UPDATE"))
                throw new ApiRuntimeException("PERMISSION_DENIED", HttpStatus.HTTP_401);

            if (!SecurityHolder.authUserSession.isSuperUser()
                    && !SecurityHolder.authUserSession.getOrganization().getId().equals(dto.getId()))
                throw new ApiRuntimeException("PERMISSION_DENIED", HttpStatus.HTTP_401);

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
    public ResponseEntity<Data<List<OrganizationDto>>> list(GenericCriteria criteria) {
        try {
            List<OrganizationDto> organizationsDto = repository.list(new GenericCriteria());
            return new ResponseEntity<>(new Data<>(organizationsDto, organizationsDto.size()));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }
}
