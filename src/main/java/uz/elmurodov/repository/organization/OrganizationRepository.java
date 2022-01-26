package uz.elmurodov.repository.organization;

import com.google.gson.reflect.TypeToken;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.property.DatabaseProperties;
import uz.elmurodov.repository.AbstractRepository;
import uz.elmurodov.repository.GenericCrudRepository;
import uz.elmurodov.repository.GenericRepository;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.settings.Types;


import java.util.List;


public class OrganizationRepository extends AbstractRepository
        implements GenericCrudRepository
        <OrganizationDto,
                OrganizationCreateDto,
                OrganizationUpdateDto,
                Long>, GenericRepository<OrganizationDto, GenericCriteria> {


    @Override
    public Long create(OrganizationCreateDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.authUserSession.getId());
        return (long) callProcedure(property.get("organization.create"), Types.BIGINT);
    }

    @Override
    public Boolean update(OrganizationUpdateDto dto) {
        prepareArguments(gson.toJson(dto), SecurityHolder.authUserSession.getId());
        return (boolean) callProcedure(UNIContainer.
                getBean(DatabaseProperties.class).get("organization.update"), Types.BOOLEAN);
    }

    @Override
    public void delete(Long id) {
        prepareArguments(SecurityHolder.authUserSession.getOrganization().getId(), id);
        callProcedure(UNIContainer.
                getBean(DatabaseProperties.class).get("delete.organization"), Types.VARCHAR);
    }

    @Override
    public OrganizationDto get(Long id) {
        prepareArguments(id);
        String jsonData = (String) callProcedure(property.get("get.organization"), Types.VARCHAR);
        return gson.fromJson(jsonData, OrganizationDto.class);
    }

    @Override
    public List<OrganizationDto> list(GenericCriteria criteria) {
        prepareArguments(SecurityHolder.authUserSession.getId());
        String JsonData = (String) callProcedure(property.get("organization.list"), Types.VARCHAR);
        return gson.fromJson(JsonData, new TypeToken<List<OrganizationDto>>() {
        }.getType());
    }
}



