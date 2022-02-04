package angelozero.webfluxapp.controller.mapper;


import angelozero.webfluxapp.controller.rest.DataRestRequest;
import angelozero.webfluxapp.controller.rest.DataRestResponse;
import angelozero.webfluxapp.service.domain.DataDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataRestMapper {

    DataRestResponse toResponse(DataDomain dataDomain);

    List<DataRestResponse> toResponseList(List<DataDomain> dataDomainList);

    DataDomain toDomain(DataRestRequest dataRestRequest);

    List<DataDomain> toDomainList(List<DataRestRequest> dataRestRequest);

}
