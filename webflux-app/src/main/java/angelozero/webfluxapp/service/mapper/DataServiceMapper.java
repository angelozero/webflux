package angelozero.webfluxapp.service.mapper;

import angelozero.webfluxapp.repository.entity.DataEntity;
import angelozero.webfluxapp.service.domain.DataDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataServiceMapper {

    DataDomain toDomain(DataEntity dataEntity);

    @Mapping(target = "id", source = "id")
    DataEntity toEntity(Long id, DataDomain dataDomain);

    DataEntity toEntity(DataDomain dataDomain);

    List<DataDomain> toDomainList(List<DataEntity> dataEntityList);

    List<DataEntity> toEntityList(List<DataDomain> dataDomainList);
}
