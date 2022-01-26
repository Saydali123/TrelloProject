package uz.elmurodov.services.column;

import uz.elmurodov.criterias.ColumnCriteria;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.column.ColumnDto;
import uz.elmurodov.dtos.column.ColumnUpdateDto;
import uz.elmurodov.repository.column.ColumnRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.AbstractService;
import uz.elmurodov.services.GenericCrudService;
import uz.elmurodov.services.GenericService;

import java.util.List;


public class ColumnService extends AbstractService<ColumnRepository>
implements GenericCrudService<ColumnDto, ColumnCreateDto, ColumnUpdateDto,Long>, GenericService<ColumnDto, ColumnCriteria> {


    public ColumnService(ColumnRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<Long>> create(ColumnCreateDto dto) {
        return new ResponseEntity<>(new Data<>(repository.create(dto)));
    }

    @Override
    public ResponseEntity<Data<ColumnDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(ColumnUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<ColumnDto>>> list(ColumnCriteria criteria) {
        return null;
    }
}
